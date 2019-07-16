package com.github.design.Null;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:15
 */
public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
