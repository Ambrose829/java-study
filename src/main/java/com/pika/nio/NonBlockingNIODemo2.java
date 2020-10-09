package com.pika.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Pika
 * @create 2020/10/9
 * @since 1.0.0
 */
public class NonBlockingNIODemo2 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("服务器端运行");
            receive();
        }, "T1").start();

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("客户端运行");
        send();

        new Thread(() -> {
            System.out.println("客户端2运行");
        }, "Con2").start();
    }

    public static void send() {
        DatagramChannel dChannel = null;
        try {
            dChannel = DatagramChannel.open();
            dChannel.configureBlocking(false);

            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String str = scanner.next();
                buf.put((new Date().toString() + "\n" + str).getBytes());
                buf.flip();
                dChannel.send(buf, new InetSocketAddress("127.0.0.1", 9898));
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





}

    public static void receive() {
        try {
            DatagramChannel dChannel = DatagramChannel.open();

            dChannel.configureBlocking(false);
            dChannel.bind(new InetSocketAddress(9898));
            Selector selector = Selector.open();

            dChannel.register(selector, SelectionKey.OP_READ);

            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();

                while  (it.hasNext()) {
                    SelectionKey sk = it.next();

                    if (sk.isReadable()) {
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        dChannel.receive(buf);
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, buf.limit()));
                        buf.clear();
                    }
                }
                it.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
