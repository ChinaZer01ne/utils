package com.github.design.iterator;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:03
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
