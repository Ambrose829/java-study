package com.pika.designPattern.template;

public class FootballGame extends Game {
    @Override
    void initialize() {
        System.out.println("足球游戏初始化完成...");
    }

    @Override
    void start() {
        System.out.println("足球游戏开始...");
    }

    @Override
    void end() {
        System.out.println("足球游戏结束...");
    }
}
