package com.pika.designPattern.strategy.cash;

public class CashDiscount extends CashStrategy {
    private double discount = 1;

    public CashDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double cashAccept(double money) {
        return discount * money;
    }
}
