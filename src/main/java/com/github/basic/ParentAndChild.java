package com.github.basic;

public class ParentAndChild {

    public String say(){
        return this.toString();
    }

}

class Child extends ParentAndChild{

    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
    public void test(){

        System.out.println(this);
        System.out.println(this.say());
        System.out.println(super.say());
    }
}
