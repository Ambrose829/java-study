package com.pika.designPattern.adapter;

/**
 * 创建实现了 AdvancedMediaPlayer 接口的实体类
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playAvi(String name) {

    }

    @Override
    public void playMp4(String name) {
        System.out.println("播放MP4类型的文件，文件名为：" + name);
    }
}
