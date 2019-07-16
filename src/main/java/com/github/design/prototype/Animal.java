package com.github.design.prototype;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:54
 */
public abstract class Animal implements Cloneable  {

    private String id;
    protected String type;

    abstract void say();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
