package com.github.design.visitor;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:30
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
