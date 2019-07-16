package com.github.design.abstarct_factory;


import com.github.design.abstarct_factory.animal.Animal;
import com.github.design.abstarct_factory.level.Level;
import com.github.design.abstarct_factory.level.Nine;
import com.github.design.abstarct_factory.level.One;
import com.github.design.abstarct_factory.level.Ten;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:40
 */
public class LevelFactory extends AbstractFactory {


    @Override
    public Level getLevel(String level) {
        if (level == null){
            return null;
        }

        switch (level){
            case "One":
                return new One();
            case "Nine":
                return new Nine();
            case "Ten":
                return new Ten();
            default:
                return null;
        }
    }

    @Override
    public Animal getAnimal(String animal) {
        return null;
    }


}
