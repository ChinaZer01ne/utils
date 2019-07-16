package com.github.design.strategy;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:22
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}