package com.pika.designPattern.factory.methodFactory;

import com.pika.factory.simpleFactory.BenZ;
import com.pika.factory.simpleFactory.Car;

public class BenZFactory implements Factory {
    @Override
    public Car getCar() {
        return new BenZ();
    }
}
