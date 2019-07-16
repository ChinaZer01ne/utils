package com.github.design.builder;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:42
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
