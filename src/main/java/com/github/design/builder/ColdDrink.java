package com.github.design.builder;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:40
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

}
