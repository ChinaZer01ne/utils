package com.github.design.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:10
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
