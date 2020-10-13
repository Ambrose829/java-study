package com.pika.designPattern.factory.methodFactory;

import com.pika.factory.simpleFactory.BMW;
import com.pika.factory.simpleFactory.Car;

public class BMWFactory implements Factory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
