package com.pika.designPattern.adapter;

/**
 * 创建实现了 MediaPlayer 接口的适配器类
 */
public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if ("avi".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer =  new AviPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer = new Mp4Player();
        }

//        else {
//            throw new RuntimeException("无法播放" + audioType + "类型的文件");
//        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if ("avi".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer.playAvi(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
