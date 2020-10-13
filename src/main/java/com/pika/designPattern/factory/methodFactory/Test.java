package com.pika.designPattern.factory.methodFactory;

public class Test {
    public static void main(String[] args) {
        BMWFactory bmwFactory = new BMWFactory();
        System.out.println(bmwFactory.getCar().getName());
        BenZFactory benZFactory = new BenZFactory();
        System.out.println(benZFactory.getCar().getName());
    }
}
