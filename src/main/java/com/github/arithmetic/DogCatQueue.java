package com.github.arithmetic;


import org.hamcrest.core.Is;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 猫狗队列问题
 * @Author: Zer01ne
 * @Date: 2019/1/21 17:13
 * @Version 1.0
 */
public class DogCatQueue {

    private Queue<PetElement> dogQueue = new LinkedList<>();
    //private Queue<Long> dogInsertDate = new LinkedList<>();   另外用一个队列表示宠物进队列的时间，这种方式也可以
    private Queue<PetElement> catQueue = new LinkedList<>();
    //private Queue<Long> catInsertDate = new LinkedList<>();
    private long count = 0;

    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        while (!dogCatQueue.isEmpty()){
            System.out.println(dogCatQueue.pollAll().getType());
        }
    }

    public void add(Pet pet){
        //if (pet instanceof Dog){
        //    Dog dog = (Dog) pet;
        //    dogQueue.add(dog);
        //    //dogInsertDate.add(System.currentTimeMillis());
        //}else if (pet instanceof Cat){
        //    Cat cat = (Cat) pet;
        //    catQueue.add(cat);
        //    //catInsertDate.add(System.currentTimeMillis());
        //}
        if (pet.getType().equals("dog")){
            dogQueue.add(new PetElement(pet,count++));
        }else if (pet.getType().equals("cat")) {
            catQueue.add(new PetElement(pet,count++));
        }else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll(){
        //if (!dogInsertDate.isEmpty() && !catInsertDate.isEmpty()){
        //    if (dogInsertDate.peek() < catInsertDate.peek()){
        //        dogInsertDate.poll();
        //        return dogQueue.poll();
        //    }else {
        //        catInsertDate.poll();
        //        return catQueue.poll();
        //    }
        //}
        //if (dogInsertDate.isEmpty()){
        //    return catQueue.poll();
        //}
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()){
            PetElement dog = dogQueue.peek();
            PetElement cat = catQueue.peek();
            if (dog.getCount() > cat.getCount()){
                return catQueue.poll().getPet();
            }else {
                return dogQueue.poll().getPet();
            }
        }else if (!dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        }else if (!catQueue.isEmpty()){
            return catQueue.poll().getPet();
        }else {
            throw new RuntimeException("err, queue is empty!");
        }
    }

    public Dog pollDog(){
        //dogInsertDate.poll();
        if (dogQueue.isEmpty()){
            throw new RuntimeException("Dog queue is empty!");
        }
        return (Dog) dogQueue.poll().getPet();
    }

    public Cat pollCat(){
        //catInsertDate.poll();
        if (catQueue.isEmpty()){
            throw new RuntimeException("Dog queue is empty!");
        }
        return (Cat) catQueue.poll().getPet();
    }

    public boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }
}


class PetElement{
    private Pet pet;
    private long count;

    public PetElement(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}


class Pet{

    private String type;

    Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}

class Dog extends Pet{

    public Dog() {
        super("dog");
    }
}