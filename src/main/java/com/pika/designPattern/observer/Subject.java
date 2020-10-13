package com.pika.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * 观察者模式属于行为型模式
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int status;

    public void attach(Observer observer) {
        observers.add(observer);

    }
    public void setStatus(int status) {
        this.status = status;
        notifyAllObervers();

    }
    public int getStatus() {
        return status;
    }

    public void notifyAllObervers() {
        for (Observer os : observers) {
            os.update();
        }
    }

}
