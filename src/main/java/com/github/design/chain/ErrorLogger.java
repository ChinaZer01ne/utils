package com.github.design.chain;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:31
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
