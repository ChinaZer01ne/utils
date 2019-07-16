package com.github.design.Null;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:14
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}