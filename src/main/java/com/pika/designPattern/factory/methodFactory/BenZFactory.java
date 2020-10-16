package com.pika.designPattern.factory.methodFactory;


import com.pika.designPattern.factory.simpleFactory.BenZ;
import com.pika.designPattern.factory.simpleFactory.Car;

public class BenZFactory implements Factory {
    @Override
    public Car getCar() {
        return new BenZ();
    }
}
