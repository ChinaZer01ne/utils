package com.github.utils.jutils;

import com.github.design.prototype.Dog;
import com.github.java8.stream.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/15 17:26
 */
public class BeanCopyUtil {



    public static void copy(Object source, Object target){

        Map<String,Object> cache = new HashMap<>();

        try {
            Class<?> sourceClass = Class.forName(source.getClass().getName());
            Class<?> targetClass = Class.forName(target.getClass().getName());

            Method[] sourceClassDeclaredMethods = sourceClass.getDeclaredMethods();
            Method[] targetClassdDeclaredMethods = targetClass.getDeclaredMethods();

            List<Method> get = Arrays.stream(sourceClassDeclaredMethods).filter(method -> method.getName().startsWith("set")).collect(Collectors.toList());
            List<Method> set = Arrays.stream(targetClassdDeclaredMethods).filter(method -> method.getName().startsWith("get")).collect(Collectors.toList());

            for (Method method : get) {
                Object result = method.invoke(source);
                cache.put(method.getName(),result);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void copyIgnoreNull(Object source, Object target){

    }

    private static void reflectField(Object o){

    }

    private BeanCopyUtil(){

    }

    public static void main(String[] args) {
        BeanCopyUtil.reflectField(new Student("ethan",1));
    }
}
