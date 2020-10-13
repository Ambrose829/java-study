package com.pika.designPattern.strategy.cash;

/**
 * 策略类，为抽象类，抽象出收费的方法供子类实现。
 */
public abstract class CashStrategy {

    public abstract double cashAccept(double money);
}
