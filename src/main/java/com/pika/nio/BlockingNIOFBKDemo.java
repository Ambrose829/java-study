package com.pika.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

/**
 * @author Pika
 * @create 2020/10/7
 * @since 1.0.0
 */
public class BlockingNIOFBKDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("服务器端运行");
            server();
        }, "T1").start();

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("客户端运行");
        client();
    }

    public static void client() {
        SocketChannel socketChannel = null;
        FileChannel inChannel = null;

        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            inChannel = FileChannel.open(Paths.get("testFiles/1.jpg"), StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }

            //如果这里不停止的话会阻塞
            socketChannel.shutdownOutput();

            //接收服务端的反馈
            int len = 0;
            while ((len = socketChannel.read(buffer)) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, len));
                buffer.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void server() {
        ServerSocketChannel ssChannel = null;
        SocketChannel sChannel = null;
        FileChannel outChannel = null;
        try {
            ssChannel = ServerSocketChannel.open();
            ssChannel.bind(new InetSocketAddress(9898));
            sChannel = ssChannel.accept();
            outChannel = FileChannel.open(Paths.get("testFiles/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (sChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }

            //发送反馈给客户端
            buf.put("服务器端接收数据成功".getBytes());
            buf.flip();
            sChannel.write(buf);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ssChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
