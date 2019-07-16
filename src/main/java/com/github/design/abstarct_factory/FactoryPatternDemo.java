package com.github.design.abstarct_factory;

import com.github.design.abstarct_factory.animal.Animal;
import com.github.design.abstarct_factory.level.Level;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:30
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        AbstractFactory animal = FactoryProducer.getFactory("ANIMAL");
        AbstractFactory level = FactoryProducer.getFactory("LEVEL");


        // 获取 Cat 的对象，并调用它的 say 方法
        Animal cat = animal.getAnimal("Cat");
        cat.say();

        // 获取 Dog 的对象，并调用它的 say 方法
        Animal dog = animal.getAnimal("Dog");
        dog.say();

        // 获取 Person 的对象，并调用它的 say 方法
        Animal person = animal.getAnimal("Person");
        person.say();

        // 获取 Level 的对象，并调用它的 level 方法
        Level one = level.getLevel("One");
        one.level();

        Level nine = level.getLevel("Nine");
        nine.level();

        Level ten = level.getLevel("Ten");
        ten.level();
    }

}
