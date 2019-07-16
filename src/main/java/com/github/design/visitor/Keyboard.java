package com.github.design.visitor;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:27
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
