package com.github.design.factory;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:30
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        // 获取 CAT 的对象，并调用它的 say 方法
        Animal cat = factory.getAnimal("CAT");
        cat.say();

        // 获取 DOG 的对象，并调用它的 say 方法
        Animal dog = factory.getAnimal("DOG");
        dog.say();

        // 获取 PERSON 的对象，并调用它的 say 方法
        Animal person = factory.getAnimal("PERSON");
        person.say();
    }

}
