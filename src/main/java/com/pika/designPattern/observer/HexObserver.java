package com.pika.designPattern.observer;
/**
 * 观察者三（订阅者三）
 * 十六进制观察者，将需要观察的对象中的status以十六进制的方式输出
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("十六进制：" + Integer.toHexString(subject.getStatus()).toUpperCase());
    }
}
