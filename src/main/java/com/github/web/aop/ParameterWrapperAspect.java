/**
 * projectName: utils
 * fileName: ParameterWrapperAspect.java
 * packageName: com.github.web.aop
 * date: 2019-11-12 19:14
 * copyright(c) 2019 http://www.hydee.cn/ Inc. All rights reserved.
 */
package com.github.web.aop;

import com.github.web.interceptor.ParameterWrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version: V1.0
 * @author: Tao Fengfeng
 * @className: ParameterWrapperAspect
 * @packageName: com.github.web.aop
 * @description:
 * @data: 2019-11-12 19:14
 **/
@Aspect
@Component
public class ParameterWrapperAspect {


    @Pointcut("execution(public * com.github.web.controller.*.*(..))")
    public void parameterWrapperService() {

    }

    @Before("parameterWrapperService()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Object[] args = joinPoint.getArgs();
        // 参数注解，1维是参数，2维是注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        // 参数
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Object param = args[i];
            Annotation[] annotations = parameterAnnotations[i];
            // 注解
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(ParameterWrapper.class)){
                    Class<?> aClass = param.getClass();
                    Field[] declaredFields = aClass.getDeclaredFields();
                    List<String> fieldName = Arrays.stream(declaredFields).map(Field::getName).collect(Collectors.toList());
                    if (fieldName.contains("groupId")){
                        Field groupId = aClass.getDeclaredField("groupId");
                        groupId.setAccessible(true);
                        groupId.set(param,100);
                    }
                    if (fieldName.contains("companyId")){
                        Field companyId = aClass.getDeclaredField("companyId");
                        companyId.setAccessible(true);
                        companyId.set(param,100001);
                    }
                    if (fieldName.contains("userId")){
                        Field userId = aClass.getDeclaredField("userId");
                        userId.setAccessible(true);
                        userId.set(param,1003);
                    }
                }
            }
        }

        System.out.println(joinPoint.getSignature());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.err.println("CustomizedAnnotationAspect:interceptParameterWrapperAnnotationMethod:ParameterWrapperAspect");
    }

}