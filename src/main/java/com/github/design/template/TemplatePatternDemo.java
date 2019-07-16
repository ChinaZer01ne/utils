package com.github.design.template;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 16:25
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
