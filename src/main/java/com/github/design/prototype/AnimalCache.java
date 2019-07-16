package com.github.design.prototype;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:03
 */
public class AnimalCache {

    private static HashMap<String, Animal> animalMap = new HashMap<>();

    public static Animal getAnimal(String shapeId) throws CloneNotSupportedException {
        Animal cachedAnimal = animalMap.get(shapeId);
        Animal cloneAnimal = (Animal) cachedAnimal.clone();

        //System.out.println(cachedAnimal == cloneAnimal);
        //说明是浅克隆
        //cloneAnimal.type = "test";

        return cloneAnimal;
    }

    public static void loadCache() {
        // Mock data
        Dog dog = new Dog();
        dog.setId("1");
        animalMap.put(dog.getId(),dog);

        Cat cat = new Cat();
        cat.setId("2");
        animalMap.put(cat.getId(),cat);

        Person person = new Person();
        person.setId("3");
        animalMap.put(person.getId(),person);
    }

}
