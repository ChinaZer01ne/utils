package com.github.design.state;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:45
 */
public class StartState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}
