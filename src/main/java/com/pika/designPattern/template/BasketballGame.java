package com.pika.designPattern.template;

public class BasketballGame extends Game {
    @Override
    void initialize() {
        System.out.println("篮球游戏初始化完成...");
    }

    @Override
    void start() {
        System.out.println("篮球游戏开始...");
    }

    @Override
    void end() {
        System.out.println("篮球游戏结束...");
    }
}
