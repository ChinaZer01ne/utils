package com.github.jvm.mermory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 *
 *    方法区产生内存溢出错误
 *
 *    Java 永久代去哪儿了: https://infoq.cn/article/Java-permgen-Removed
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 10:18
 */
public class MyTest4 {
    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);

            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy) -> proxy.invokeSuper(obj,args1));

            System.out.println("Hello world");

            enhancer.create();
        }
    }
}
