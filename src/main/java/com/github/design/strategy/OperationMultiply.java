package com.github.design.strategy;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:22
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
