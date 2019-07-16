package com.github.design.prototype;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:08
 */
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        AnimalCache.loadCache();

        Animal cloneAnimal = AnimalCache.getAnimal("1");
        System.out.println("Animal : " + cloneAnimal.getType());

        Animal cloneAnimal2 = AnimalCache.getAnimal("2");
        System.out.println("Animal : " + cloneAnimal2.getType());

        Animal cloneAnimal3 = AnimalCache.getAnimal("3");
        System.out.println("Animal : " + cloneAnimal3.getType());
    }
}
