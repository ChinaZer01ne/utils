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

        //if (!(handler instanceof HandlerMethod)){
        //    return true;
        //}
        //Map<String, String[]> parameterMap = request.getParameterMap();
        //Map<String, String[]> modifyParameterMap = new HashMap<>(request.getParameterMap());
        //HandlerMethod method = (HandlerMethod) handler;
        //
        //MethodParameter[] methodParameters = method.getMethodParameters();
        ////for (MethodParameter methodParameter : methodParameters) {
        //    //methodParameter.getParameter().
        //
        ////}
        //Parameter[] parameters = method.getMethod().getParameters();
        //for (Parameter parameter : parameters) {
        //    Field[] declaredFields = parameter.getType().getDeclaredFields();
        //    //Arrays.stream(declaredFields).filter(field -> field.getName().equalsIgnoreCase("cgCode"));
        //    List<String> fieldNames = Arrays.stream(declaredFields).map(Field::getName).collect(Collectors.toList());
        //    if (fieldNames.contains("groupId")){
        //        modifyParameterMap.put("groupId", new String[]{request.getHeader("groupId")});
        //        //request.setAttribute("groupId",request.getHeader("groupId"));
        //        //request.getParameterMap().put("groupId", new String[]{request.getHeader("groupId")});
        //    }
        //    if (fieldNames.contains("companyId")){
        //        modifyParameterMap.put("companyId", new String[]{request.getHeader("companyId")});
        //        //request.setAttribute("companyId",request.getHeader("companyId"));
        //        //request.getParameterMap().put("companyId", new String[]{request.getHeader("companyId")});
        //    }
        //    if (fieldNames.contains("userId")){
        //        modifyParameterMap.put("userId", new String[]{request.getHeader("userId")});
        //        //request.setAttribute("userId",request.getHeader("userId"));
        //        //request.getParameterMap().put("userId", new String[]{request.getHeader("userId")});
        //    }
        //}

        //System.err.println("执行方法" + request.getMethod());
        //Map<String, String[]> parameterMap = request.getParameterMap();
        //System.out.println("参数列表" + parameterMap);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}