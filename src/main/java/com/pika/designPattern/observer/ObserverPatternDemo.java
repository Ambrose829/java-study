package com.pika.designPattern.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        System.out.println("将status改为14");
        subject.setStatus(14);
        System.out.println("将status改为10");
        subject.setStatus(10);
    }
}
