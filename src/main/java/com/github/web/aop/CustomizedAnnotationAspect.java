package com.github.web.aop;

import com.github.web.interceptor.ParameterWrapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 *
 * 注解的切面
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/6 11:26
 */
@Aspect
@Component
public class CustomizedAnnotationAspect {




    @Pointcut("@annotation(com.github.web.aop.CustomizedAnnotation)")
    public void customizedAnnotationService() {

    }

    @Around("customizedAnnotationService()")
    public Object interceptCustomizedAnnotationMethod(ProceedingJoinPoint pjp) throws Throwable {


        System.out.println("args : " + Arrays.toString(pjp.getArgs()));
        System.out.println("kind : " + pjp.getKind());
        System.out.println("signature : " + pjp.getSignature());
        System.out.println("sourceLocation : " + pjp.getSourceLocation());
        System.out.println("staticPart : " + pjp.getStaticPart());
        System.out.println("target : " + pjp.getTarget());
        System.out.println("this : " + pjp.getThis());
        System.out.println("class : " + pjp.getClass());

        System.err.println("CustomizedAnnotationAspect:interceptCustomizedAnnotationMethod");
        return pjp.proceed();
    }


}
