package com.pika.designPattern.strategy.cash;

public class CashFullReduction extends CashStrategy {
    private double full = 0.0;
    private double reduction = 0.0;

    public CashFullReduction(double full, double reduction) {
        this.full = full;
        this.reduction = reduction;
    }

    @Override
    public double cashAccept(double money) {
        if (money >= full) {
            money -= Math.floor(money / full) * reduction;
        }
        return money;
    }
}
