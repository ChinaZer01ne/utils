package com.github.design.observer;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:30
 */
public abstract  class Observer {
    protected Subject subject;
    public abstract void update();
}
