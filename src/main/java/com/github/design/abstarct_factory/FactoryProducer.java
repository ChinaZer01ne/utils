package com.github.design.abstarct_factory;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:56
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type){

        if ("ANIMAL".equalsIgnoreCase(type)){
            return new AnimalFactory();
        }else if ("LEVEL".equalsIgnoreCase(type)){
            return new LevelFactory();
        }

        return null;
    }
}
