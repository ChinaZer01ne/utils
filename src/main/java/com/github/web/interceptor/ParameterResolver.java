package com.github.web.interceptor;

import com.github.web.aop.CustomizedAnnotation;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @version: V1.0
 * @author: Tao Fengfeng
 * @className: ParameterInterceptor
 * @packageName: com.github.web.interceptor
 * @description:
 * @data: 2019-11-04 16:29
 **/
public class ParameterResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        return methodParameter.hasParameterAnnotation(ParameterWrapper.class);

    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
        ParameterWrapper annotation = annotatedElement.getAnnotation(ParameterWrapper.class);

        if (annotation != null){
            try {

                Constructor<?> constructor = methodParameter.getConstructor();
                Object o = Objects.requireNonNull(constructor).newInstance();

                Field groupId = methodParameter.getParameter().getType().getField("groupId");
                groupId.setAccessible(true);
                groupId.setInt(o,100);

                Field companyId = methodParameter.getParameter().getType().getField("companyId");
                companyId.setAccessible(true);
                companyId.setInt(o,100);

                Field userId = methodParameter.getParameter().getType().getField("userId");
                userId.setAccessible(true);
                userId.setInt(o,100);
                System.err.println("参数绑定测试");
                return o;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.err.println("参数绑定测试");
        return null;
    }
}