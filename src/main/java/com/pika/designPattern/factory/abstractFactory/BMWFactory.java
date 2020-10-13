package com.pika.designPattern.factory.abstractFactory;

import com.pika.factory.simpleFactory.BMW;
import com.pika.factory.simpleFactory.Car;

public class BMWFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
