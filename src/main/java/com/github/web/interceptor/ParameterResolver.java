package com.github.web.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

/**
 * @version: V1.0
 * @author: Tao Fengfeng
 * @className: ParameterInterceptor
 * @packageName: com.github.web.interceptor
 * @description:
 * @data: 2019-11-04 16:29
 **/
@Component
public class ParameterResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        System.err.println("参数绑定测试");
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        System.err.println("参数绑定测试");
        return null;
    }
}