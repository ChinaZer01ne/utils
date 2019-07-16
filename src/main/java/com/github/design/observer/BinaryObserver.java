package com.github.design.observer;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:31
 */
public class BinaryObserver  extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }

}
