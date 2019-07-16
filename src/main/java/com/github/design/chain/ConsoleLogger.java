package com.github.design.chain;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:30
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
