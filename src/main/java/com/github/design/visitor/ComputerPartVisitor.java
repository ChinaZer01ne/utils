package com.github.design.visitor;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:29
 */
public interface  ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}
