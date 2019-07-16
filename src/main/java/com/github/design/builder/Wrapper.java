package com.github.design.builder;

/**
 * 创建实现 Packing 接口的实体类
 *
 * 袋装
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:36
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
