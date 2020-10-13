package com.pika.designPattern.adapter;

/**
 * 普通播放器
 */
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("播放MP3类型的文件，文件名为：" + fileName);
        } else if ("avi".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)){
            mediaAdapter= new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("无法播放" + audioType + "类型的文件");
        }

    }
}
