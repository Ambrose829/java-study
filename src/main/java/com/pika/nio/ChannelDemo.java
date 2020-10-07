package com.pika.nio;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author Pika
 * @create 2020/10/7
 * @since 1.0.0
 *
 * 一、通道(Channel)：用于原节点与目标节点的连接。在Java NIO中负责缓冲区中数据的传输。
 * Channel本身不存储数据，因此需要配合缓冲器进行传输
 *
 *
 * 二、通道的主要实现类
 * java.nio.channels.Channel接口
 *  FileChannel
 *  SocketChannel
 *  ServerSocketChannel
 *  DatagrmChannel
 *
 * 三、获取通道
 * 1 java针对支持通道的类提供了getChannel()方法
 * 本地IO操作
 *  FileInputStream/FileOutputStream
 *  RandomAccessFile
 * 网络IO
 *  Socket
 *  ServerSocket
 *  DatagramSocket
 *
 * 2 在JDK1.7中的NIO.2 针对各个通道提供静态方法 open()
 * 2 在JDK1.7中的NIO.2的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 *  transferTo()
 *  transferFrom()
 *
 *  五、分散（Scatter）与聚集（Gather）
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中去
 * 聚集写入（Gathering Writes）：将多个缓冲区的数据聚集到一个通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组 -> 字符串
 *
 *
 */
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
//        copyTest();
//        directCopyTest();
//        channelCopyTest();
//        scatterGatherCopyTest();
        charsetTest();


    }


    //1.利用通道完成文件的复制(非直接缓冲区)
    public static void copyTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("testFiles/1.jpg");
            fos = new FileOutputStream("testFiles/2.jpg");

            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //将通道中的数据写入缓冲区
            while (inChannel.read(buf) != -1) {
                buf.flip();
                //将缓冲区中的数据写入通道
                outChannel.write(buf);
                buf.clear();//清空缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件)
    public static void directCopyTest() {

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("testFiles/1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("testFiles/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

            //内存映射文件
            MappedByteBuffer inMapperBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMapperBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMapperBuffer.limit()];
            inMapperBuffer.get(dst);
            outMapperBuffer.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


    //3.通道之间数据传输(直接缓冲区)
    public static void channelCopyTest() {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("testFiles/1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("testFiles/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
            inChannel.transferTo(0, inChannel.size(), outChannel);
//            outChannel.transferFrom(inChannel, 0, inChannel.size());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //4.分散聚集
    public static void scatterGatherCopyTest() throws Exception {

        RandomAccessFile raf1 = new RandomAccessFile("testFiles/1.txt", "rw");

        //1.获取通道
        FileChannel channel1 = raf1.getChannel();

        //2.分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("===================================================");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4.聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("testFiles/2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

        channel2.close();
        channel1.close();



    }

    //5.字符集
    public static void charsetTest() {
//        查看所有字符集
//        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();
//        Set<Map.Entry<String, Charset>> entries = charsetSortedMap.entrySet();
//        for(Map.Entry<String, Charset> entry : entries) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }

        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("皮卡NIO");


    }
}
