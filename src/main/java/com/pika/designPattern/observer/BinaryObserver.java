package com.pika.designPattern.observer;

/**
 * 观察者一（订阅者一）
 * 二进制观察者，将需要观察的对象中的status以二进制的方式输出
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("二进制：" + Integer.toBinaryString(subject.getStatus()));
    }
}
