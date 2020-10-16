package com.pika.designPattern.factory.abstractFactory;


import com.pika.designPattern.factory.simpleFactory.BMW;
import com.pika.designPattern.factory.simpleFactory.BenZ;
import com.pika.designPattern.factory.simpleFactory.Car;

/**
 * 抽象工厂（AbstractFactory）角色 ：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
 *
 * 具体工厂类（ConreteFactory）角色 ：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
 *
 * 抽象产品（Abstract Product）角色 ：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
 *
 * 具体产品（Concrete Product）角色 ：抽象工厂模式所创建的任何产品对象都是某一个具体产品类的实例。
 * 在抽象工厂中创建的产品属于同一产品族，这不同于工厂模式中的工厂只创建单一产品，我后面也会详解介绍到。
 *
 */
public abstract class AbstractFactory {
    public abstract Car getCar();

    //动态配置汽车情况
    public Car getCar(String name) {
        if ("BMW".equals(name)) {
            return new BMW();
        } else if ("BenZ".equals(name)) {
            return new BenZ();
        }else {
            System.out.println("目前暂不支持生产"+name);
            return null;
        }
    }

}
