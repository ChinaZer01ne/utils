package com.github.design.Interpreter;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:50
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}
