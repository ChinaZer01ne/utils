package com.github.design.abstarct_factory;


import com.github.design.abstarct_factory.animal.Animal;
import com.github.design.abstarct_factory.animal.Cat;
import com.github.design.abstarct_factory.animal.Dog;
import com.github.design.abstarct_factory.animal.Person;
import com.github.design.abstarct_factory.level.Level;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:40
 */
public class AnimalFactory extends AbstractFactory {

    @Override
    public Level getLevel(String level) {
        return null;
    }

    @Override
    public Animal getAnimal(String animal) {

        if (animal == null){
            return null;
        }

        switch (animal){
            case "Cat":
                return new Cat();
            case "Dog":
                return new Dog();
            case "Person":
                return new Person();
            default:
                return null;
        }

    }
}
