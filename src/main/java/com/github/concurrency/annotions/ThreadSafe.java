package com.github.concurrency.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，标记线程安全的类
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 13:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
