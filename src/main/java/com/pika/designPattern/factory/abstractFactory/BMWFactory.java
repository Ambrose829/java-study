package com.pika.designPattern.factory.abstractFactory;


import com.pika.designPattern.factory.simpleFactory.BMW;
import com.pika.designPattern.factory.simpleFactory.Car;

public class BMWFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
