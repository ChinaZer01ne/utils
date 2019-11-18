package com.github.web.filter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
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
import java.util.HashMap;
import java.util.Map;

@Component
@WebFilter(urlPatterns={"/*"})
public class RequestWrapperFilter implements Filter {

    private static final String FORM_SUBMIT = "application/x-www-form-urlencoded";
    private static final int BUFFER_SIZE = 512;
    private static final String JSON_OBJ_PREFIX = "{";
    private static final String PARAM_GROUP_ID = "groupId";
    private static final String PARAM_COMPANY_ID = "companyId";
    private static final String PARAM_USER_ID = "userId";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contentType = request.getContentType();

        ParameterRequestWrapper parameterWrapper = new ParameterRequestWrapper(request);

        // request param handle
        parameterWrapper.addAllParameters(wrapperRequestParam(request));

        // 如果不是文件上传，也不是"application/x-www-form-urlencoded",
        if (!ServletFileUpload.isMultipartContent(request) && !FORM_SUBMIT.equalsIgnoreCase(contentType)) {
            // request body handle
            parameterWrapper.setBody(wrapperRequestBody(request));
        }

        filterChain.doFilter(parameterWrapper,servletResponse);
    }

    /**
     * 封装请求参数，针对@RequestParam
     */
    private Map<String, Object> wrapperRequestParam(HttpServletRequest request) throws IOException {
        Map<String, Object> extendParamMap = new HashMap<>(8);
        injectParam(extendParamMap,request);
        return extendParamMap;
    }
    /**
     * 封装请求体
     */
    @SuppressWarnings("unchecked")
    private String wrapperRequestBody(HttpServletRequest request) throws IOException {

        String requestBody = getRequestBody(request);

        if (requestBody.startsWith(JSON_OBJ_PREFIX)){
            Map<String,Object> sourceMap = JSONObject.parseObject(requestBody, Map.class);
            injectParam(sourceMap,request);
            return JSONObject.toJSONString(sourceMap);
        }

        return requestBody;

    }

    /**
     * 注入通用参数
     */
    private void injectParam(Map<String, Object> sourceMap, HttpServletRequest request){
        sourceMap.put(PARAM_GROUP_ID, request.getHeader(PARAM_GROUP_ID));
        sourceMap.put(PARAM_COMPANY_ID, request.getHeader(PARAM_COMPANY_ID));
        sourceMap.put(PARAM_USER_ID, request.getHeader(PARAM_USER_ID));
    }
    /**
     * 读取请求体
     */
    @SuppressWarnings("unchecked")
    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        // request body
        byte[] data = new byte[BUFFER_SIZE];

        ServletInputStream inputStream = request.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int length = 0;
        while ((length = bufferedInputStream.read(data)) != -1){
            stringBuilder.append(new String(data,0,length));
        }
        if (StringUtils.isBlank(stringBuilder.toString())){
            return StringUtils.EMPTY;
        }else {
            return stringBuilder.toString();
        }

    }


}