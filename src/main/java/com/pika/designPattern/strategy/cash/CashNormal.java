package com.pika.designPattern.strategy.cash;

/**
 * 没有任何活动的情况，正常收费，返回原价
 */
public class CashNormal extends CashStrategy {
    @Override
    public double cashAccept(double money) {
        return money;
    }
}
