package com.github.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/13 13:38
 * @Version 1.0
 */
public class DynamicProxy implements InvocationHandler {

    private Animal animal;
    public DynamicProxy(Animal animal){
        this.animal = animal;
    }
    public Animal createProxy(){
        return (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(),animal.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Person person = (Person) animal;
        System.out.println(person.getName());
        Object value = method.invoke(animal, args);
        System.out.println("这个对象被代理了");
        return value;
    }

    public static void main(String[] args) {
        DynamicProxy animal = new DynamicProxy(new Person());
        Animal person = animal.createProxy();
        person.eat();
    }
}
