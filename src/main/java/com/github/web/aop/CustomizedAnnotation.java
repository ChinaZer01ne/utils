package com.github.web.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 主要是来测试aop
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/6 11:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.TYPE_PARAMETER,ElementType.PARAMETER})
public @interface CustomizedAnnotation {

    String value() default "test message...";
}
