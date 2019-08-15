package com.github.utils.jutils;

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
        copy(source,target,false);
    }

    public static void copyIgnoreNull(Object source, Object target){
        copy(source,target,true);
    }

    private static void copy(Object source, Object target, boolean ignoreNull){
        // FieldName : Method
        Map<String,Object> sourceReadMap = new HashMap<>(16);
        // FieldName : Method
        Map<String,Object> targetWriteMap = new HashMap<>(16);

        try {
            Class<?> sourceClass = Class.forName(source.getClass().getName());
            Class<?> targetClass = Class.forName(target.getClass().getName());

            Method[] sourceClassDeclaredMethods = sourceClass.getDeclaredMethods();
            Method[] targetClassdDeclaredMethods = targetClass.getDeclaredMethods();

            List<Method> getMethodList = Arrays.stream(sourceClassDeclaredMethods).filter(method -> method.getName().startsWith("get")).collect(Collectors.toList());

            for (Method method : getMethodList) {
                sourceReadMap.put(method.getName().substring(3).toUpperCase(),method);
            }


            List<Method> setMethodList = Arrays.stream(targetClassdDeclaredMethods).filter(method -> method.getName().startsWith("set")).collect(Collectors.toList());

            for (Method method : setMethodList) {
                targetWriteMap.put(method.getName().substring(3).toUpperCase(),method);
            }

            for (Map.Entry<String, Object> sourceFieldMethodMap : sourceReadMap.entrySet()) {
                String sourceField = sourceFieldMethodMap.getKey();
                Method sourceMethod = (Method) sourceFieldMethodMap.getValue();
                sourceMethod.setAccessible(true);
                Object result = sourceMethod.invoke(source);
                // 忽略null属性
                if (ignoreNull && result == null){
                    continue;
                }
                for (Map.Entry<String, Object> targetFieldMethodMap : targetWriteMap.entrySet()) {
                    String targetField = targetFieldMethodMap.getKey();
                    if (targetField.equals(sourceField)){
                        Method targetMethod = (Method) targetFieldMethodMap.getValue();
                        targetMethod.setAccessible(true);
                        targetMethod.invoke(target,result);
                    }
                }
            }

        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private BeanCopyUtil(){

    }


}
