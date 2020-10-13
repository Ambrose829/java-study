package com.pika.designPattern.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "没有理想的人不伤心.mp3");
        audioPlayer.play("mp4", "你要跳舞吗.mp4");
        audioPlayer.play("avi", "杀死那个石家庄人.avi");
        audioPlayer.play("vlc", "咸鱼.vlc");

    }
}
