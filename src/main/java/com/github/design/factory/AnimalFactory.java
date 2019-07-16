package com.github.design.factory;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:18
 */
public class AnimalFactory {

    /**
     * 使用 getAnimal 方法获取形状类型的对象
     */
    public Animal getAnimal(String animalType){

        if (animalType == null){
            return null;
        }

        switch (animalType){
            case "CAT":
                return new Cat();
            case "DOG":
                return new Dog();
            case "PERSON":
                return new Person();
            default:
                return null;
        }
    }
}
