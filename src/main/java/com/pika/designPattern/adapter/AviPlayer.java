package com.pika.designPattern.adapter;

/**
 * 创建实现了 AdvancedMediaPlayer 接口的实体类
 */
public class AviPlayer implements AdvanceMediaPlayer {
    @Override
    public void playAvi(String name) {
        System.out.println("播放avi类型的文件，文件名为：" + name);
    }

    @Override
    public void playMp4(String name) {

    }
}
