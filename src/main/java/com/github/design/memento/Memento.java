package com.github.design.memento;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:09
 */
public class Memento {

    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
