package com.pika.designPattern.strategy.cash;

/**
 * 上下文类
 * 首先声明一个CashSuper对象，通过构造方法，传入具体的收费策略，getResult()方法的功能为根据收费策略的不同获得计算结果
 */
public class CashContext {
    private CashStrategy cashStrategy;
    public CashContext(CashStrategy cashStrategy) {
        this.cashStrategy = cashStrategy;
    }
    public double getResult(double money) {
        return cashStrategy.cashAccept(money);
    }

}
