package com.pika.nio;


import java.nio.ByteBuffer;

/**
 * @author Pika
 * @create 2020/10/6
 * @since 1.0.0
 *
 * 一、缓冲区：在java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 *  根据数据类型不同(boolean除外)，提供了相应类型的缓冲区
 *  ByteBuffer
 *  CharBuffer
 *  ShortBuffer
 *  IntBuffer
 *  LongBuffer
 *  FloatBuffer
 *  DoubleBuffer
 *
 *  上述缓冲区管理方式几乎一致，通过allocate() 获取缓冲区
 *
 *  二、缓冲器存区数据的两个核心方法
 *  put() ：存入数据到缓冲区内
 *  get() ：获取缓冲区的数据
 *
 *  三、缓冲区中的四个核心属性
 *  capacity ：容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 *  limit ：限制，表示缓冲区中可以操作数据的大小。（limit外的数据不能进行读写）
 *  position ： 位置，表示缓冲区中正在操作数据的位置
 *  mark ：标记，表示记录当前position的位置。可以通过reset()恢复到mark位置
 *  0 <= mark <= position <= limit <= capacity
 *
 *  四、直接缓冲区和非直接缓冲区
 *  非直接缓冲区，通过allocate(), 方法分配缓冲区，将缓冲区建立在JVM的内存中
 *  直接缓冲区，通过allocateDirect(), 方法分配直接缓冲区，将缓冲区放在物理内存中
 *
 *
 */
public class BufferDemo {
    public static void main(String[] args) {
//        buffer();
//        markTest();
        directBuffer();
    }


    public static void buffer() {
        String str = "happy";
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("======allocate()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.利用put存入数据到缓冲区
        buf.put(str.getBytes());
        System.out.println("======put()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //3.切换成读取数据的模式
        buf.flip();
        System.out.println("======flip()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //4.利用get获取缓存区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("======get()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //5.rewind方法,可重复读数据，恢复
        buf.rewind();
        System.out.println("======rewind()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //6.clear清空缓冲区,但是缓冲区中的数据依然存在，但是处于被遗忘状态
        buf.clear();
        System.out.println("======clear()=======");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

    }

    //测试mark标记
    public static void markTest() {
        String str = "happy";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println(buf.position());
        buf.mark();
        buf.get(dst, 2, 2);
        System.out.println(buf.position());
        buf.reset();
        System.out.println(buf.position());
    }

    //测试直接缓冲区
    public static void directBuffer() {
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
    }

}
