package com.github.web.filter;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.entity.ContentType;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.fusesource.hawtbuf.BufferInputStream;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Component
@WebFilter(urlPatterns={"/*"})
public class RequestWrapperFilter implements Filter {

    private static final String FORM_SUBMIT = "application/x-www-form-urlencoded";
    private static final int BUFFER_SIZE = 512;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contentType = request.getContentType();

        ParameterRequestWrapper parameterWrapper = new ParameterRequestWrapper(request);

        parameterWrapper.addParameter("groupId", request.getHeader("groupId"));
        parameterWrapper.addParameter("companyId",request.getHeader("companyId"));
        parameterWrapper.addParameter("userId",request.getHeader("userId"));

        // 如果不是文件上传，也不是"application/x-www-form-urlencoded",
        if (!ServletFileUpload.isMultipartContent(request) && !FORM_SUBMIT.equalsIgnoreCase(contentType)) {
            // request body handle
            parameterWrapper.setBody(wrapperRequestBody(request));
        }

        filterChain.doFilter(parameterWrapper,servletResponse);
    }
    /**
     * 封装请求体
     */
    @SuppressWarnings("unchecked")
    private String wrapperRequestBody(HttpServletRequest request) throws IOException {
        Map<String,Object> sourceMap = JSONObject.parseObject(getRequestBody(request), Map.class);
        sourceMap.put("groupId", request.getHeader("groupId"));
        sourceMap.put("companyId", request.getHeader("companyId"));
        sourceMap.put("userId", request.getHeader("userId"));
        return JSONObject.toJSONString(sourceMap);
    }
    /**
     * 读取请求体
     */
    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        // request body
        byte[] data = new byte[BUFFER_SIZE];

        ServletInputStream inputStream = request.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int length = bufferedInputStream.read(data);
        while (length != -1){
            length = bufferedInputStream.read(data);
            stringBuilder.append(new String(data));
        }

        return stringBuilder.toString();
    }


}