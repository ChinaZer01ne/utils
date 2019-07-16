package com.github.design.state;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:47
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
    @Override
    public String toString(){
        return "Stop State";
    }
}
