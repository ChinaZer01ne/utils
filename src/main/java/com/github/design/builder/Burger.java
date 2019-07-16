package com.github.design.builder;

/**
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:38
 */
public abstract class Burger implements Item {


    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
