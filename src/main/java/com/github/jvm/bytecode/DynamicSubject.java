package com.github.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/18 16:49
 */
public class DynamicSubject implements InvocationHandler {

    private Object target;

    public DynamicSubject(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before execute");
        method.invoke(target,args);
        System.out.println("after execute");

        return proxy;
    }

    public static void main(String[] args) {
        RealSubject target = new RealSubject();

        //System.getProperties().put("sum.misc.ProxyGenerator.saveGeneratedFiles",true);
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles",true);
        System.out.println(System.getProperties().get("jdk.proxy.ProxyGenerator.saveGeneratedFiles"));

        DynamicSubject dynamicSubject = new DynamicSubject(target);
        Subject subject = (Subject) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), dynamicSubject);
        subject.test();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
