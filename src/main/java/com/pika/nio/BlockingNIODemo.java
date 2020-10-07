package com.pika.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

/**
 * @author Pika
 * @create 2020/10/7
 * @since 1.0.0
 *
 *
 * 一、使用NIO完成网络通信的三个核心：
 *  1.通道(Channel) : 负责连接
 *      java.nio.channels.Channel 接口
 *          SelectableChannel
 *              SocketChannel
 *              ServerSocketChannel
 *              DatagramChannel
 *
 *              Pipe.SinkChannel
 *              Pipe.SourceChannel
 *  2.缓冲区(Buffer) : 负责数据的存区
 *  3.选择器(Slector) : 是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 *
 *
 */
public class BlockingNIODemo {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("服务器端运行");
            server();
        }, "T1").start();

        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("客户端运行");
        client();

    }

    //客户端
    public static void client() {
        SocketChannel sChannel = null;
        FileChannel inChannel = null;
        try {
            //1.获取通道
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

            //2.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3.读取本地文件并发送到服务端去
            inChannel = FileChannel.open(Paths.get("testFiles/1.jpg"), StandardOpenOption.READ);
            while (inChannel.read(buf) != -1) {
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭通道
            try {
                inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
    //服务端
    public static void server() {
        ServerSocketChannel ssChannel = null;
        SocketChannel sChannel = null;
        FileChannel outChannel = null;

        try {
            //1.获取通道
            ssChannel = ServerSocketChannel.open();

            //2.绑定链接
            ssChannel.bind(new InetSocketAddress(9898));

            //3.获取客户端连接的通道
            sChannel = ssChannel.accept();

            //4.分配一个指定大小的缓冲区，用以将数据写入本地
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //5.接收客户端的数据，并保存到本地
            outChannel = FileChannel.open(Paths.get("testFiles/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            while (sChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭通道
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
