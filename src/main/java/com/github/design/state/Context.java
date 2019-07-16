package com.github.design.state;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:46
 */
public class Context {

    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
