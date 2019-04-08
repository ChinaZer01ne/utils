package com.github.java8.function;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 14:47
 */
public class Company {
    private String name;
    private List<Employee> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}
