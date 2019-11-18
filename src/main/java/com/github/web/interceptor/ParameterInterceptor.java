package com.github.web.interceptor;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ParameterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //TODO 拦截器不能实现对参数的封装，此时参数对象并没有生成？
        HandlerMethod method = (HandlerMethod) handler;
        for (MethodParameter methodParameter : method.getMethodParameters()) {
            if (methodParameter.hasParameterAnnotation(ParameterWrapper.class)) {
                Field groupId = methodParameter.getParameterType().getDeclaredField("groupId");
                groupId.setAccessible(true);
                groupId.set(methodParameter.getParameter(),100);
                //methodParameter.getParameter()
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}