package com.github.design.visitor;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:26
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
