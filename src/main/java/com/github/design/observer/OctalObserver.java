package com.github.design.observer;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:32
 */
public class OctalObserver  extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
