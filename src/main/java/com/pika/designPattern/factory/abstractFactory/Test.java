package com.pika.designPattern.factory.abstractFactory;

public class Test {
    public static void main(String[] args) {
        DefualtFactory defualtFactory = new DefualtFactory();
        System.out.println(defualtFactory.getCar("BMW").getName());
    }
}
