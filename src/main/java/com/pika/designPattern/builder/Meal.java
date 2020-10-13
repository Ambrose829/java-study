package com.pika.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item it : items) {
            cost += it.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item it : items) {
            System.out.println("item: " + it.name()
                    + ", packing: " + it.packing().pack()
                    + ", price: " + it.price());
        }
    }
}
