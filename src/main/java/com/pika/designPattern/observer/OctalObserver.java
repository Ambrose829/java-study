package com.pika.designPattern.observer;
/**
 * 观察者二（订阅者二）
 * 八进制观察者，将需要观察的对象中的status以八进制的方式输出
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("八进制：" + Integer.toOctalString(subject.getStatus()));
    }

}
