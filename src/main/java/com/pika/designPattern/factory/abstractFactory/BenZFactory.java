package com.pika.designPattern.factory.abstractFactory;


import com.pika.designPattern.factory.simpleFactory.BenZ;
import com.pika.designPattern.factory.simpleFactory.Car;

public class BenZFactory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BenZ();
    }
}
