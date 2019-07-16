package com.github.design.abstarct_factory;

import com.github.design.abstarct_factory.animal.Animal;
import com.github.design.abstarct_factory.level.Level;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 11:18
 */
public abstract class AbstractFactory  {

    /**
     * 获取 level
     */
    public abstract Level getLevel(String level);
    /**
     * 获取 animal
     */
    public abstract Animal getAnimal(String animal) ;
}
