package com.pika.designPattern.builder;

public class MealBuilder {
    public Meal ZingerBurgerCombo() {
        Meal meal = new Meal();
        meal.addItem(new ZingerBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal BeeefBurgerCombo() {
        Meal meal = new Meal();
        meal.addItem(new BeefBurger());
        meal.addItem(new Coca());
        return  meal;
    }
}
