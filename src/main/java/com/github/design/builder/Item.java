package com.github.design.builder;

/**
 * 创建一个表示食物条目和食物包装的接口。
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:34
 */
public interface Item {
    /**
     * 商品名
     */
    String name();
    /**
     * 包装方式
     */
    Packing packing();
    /**
     * 价格
     */
    float price();
}
