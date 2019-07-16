package com.github.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:30
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
