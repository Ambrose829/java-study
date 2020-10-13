package com.pika.designPattern.builder;

public class BuilderParternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal zingerBurgerCombo = mealBuilder.ZingerBurgerCombo();
        Meal beeefBurgerCombo = mealBuilder.BeeefBurgerCombo();
        System.out.println("香辣鸡腿堡套餐：");
        zingerBurgerCombo.showItems();
        System.out.println("共消费: " + zingerBurgerCombo.getCost());
        System.out.println("牛肉堡套餐：");
        beeefBurgerCombo.showItems();
        System.out.println("共消费：" + beeefBurgerCombo.getCost());
    }
}
