package com.github.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/21 17:21
 * @Version 1.0
 */
public class PersonInterceptor implements HandlerInterceptor {

    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("===方法执行之前===");
        return true;
    }
    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("===方法拦截器之后===");
    }
    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.err.println("===请求执行完成===");
    }
}
