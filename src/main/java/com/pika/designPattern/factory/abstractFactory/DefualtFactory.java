package com.pika.designPattern.factory.abstractFactory;


import com.pika.designPattern.factory.simpleFactory.Car;
import com.pika.designPattern.factory.simpleFactory.Default;

public class DefualtFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new Default();
    }
}
