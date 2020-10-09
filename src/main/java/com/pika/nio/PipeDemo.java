package com.pika.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author Pika
 * @create 2020/10/9
 * @since 1.0.0
 */
public class PipeDemo {

    public static void main(String[] args) {
        pipe();
    }

    public static void pipe() {
        Pipe.SinkChannel sinkChannel = null;
        Pipe.SourceChannel sourceChannel = null;
        try {
            //1.获取管道
            Pipe pipe = Pipe.open();

            //2.将缓冲区的数据些入管道
            ByteBuffer buf = ByteBuffer.allocate(1024);

            sinkChannel = pipe.sink();

            buf.put("通过单向管道发送数据".getBytes());
            buf.flip();
            sinkChannel.write(buf);

            //3.读取缓冲区中的数据
            sourceChannel = pipe.source();
            buf.flip();
            int len = sourceChannel.read(buf);
            System.out.println(new String(buf.array(), 0, len) + "  接收端");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sinkChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
