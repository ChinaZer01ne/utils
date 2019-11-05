package com.github.web.filter;


import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.util.Assert;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String , String[]> params = new HashMap<>();
    private String body;


    public ParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(request.getParameterMap());
    }

    public ParameterRequestWrapper(HttpServletRequest request, String body) {
        this(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.body = body;
    }

    //重载一个构造方法
    public ParameterRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
        this(request);
        // 这里将扩展参数写入参数表
        addAllParameters(extendParams);
    }
    /**
     * 重写getParameter，代表参数从当前类中的map获取
     * */
    @Override
    public String getParameter(String name) {
        String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }


    public void addAllParameters(Map<String , Object>otherParams) {
        for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
            addParameter(entry.getKey() , entry.getValue());
        }
    }


    public void addParameter(String name , Object value) {
        if (value != null) {
            if (value instanceof String[]) {
                params.put(name, (String[]) value);
            } else if (value instanceof String) {
                params.put(name, new String[]{(String) value});
            } else {
                params.put(name, new String[]{String.valueOf(value)});
            }
        }
    }
    @Override
    public Map<String, String[]> getParameterMap() {
        return params;
    }
    /**
     * SpringMVC 会调用这个方法来获取表单提交的参数
     */
    @Override
    public Enumeration<String> getParameterNames() {
        return new CustomizedEnumeration<>(params.keySet().iterator());
    }
    /**
     * SpringMVC 会调用这个方法来获取非表单提交的参数
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new DelegatingServletInputStream(new ByteArrayInputStream(body.getBytes()));
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 装饰类，包装成 {@code ServletInputStream} 返回
     */
    private static class DelegatingServletInputStream extends ServletInputStream  {
        private final InputStream sourceStream;
        private boolean finished = false;

        DelegatingServletInputStream(InputStream sourceStream) {
            Assert.notNull(sourceStream, "Source InputStream must not be null");
            this.sourceStream = sourceStream;
        }

        public final InputStream getSourceStream() {
            return this.sourceStream;
        }
        @Override
        public int read() throws IOException {
            int data = this.sourceStream.read();
            if (data == -1) {
                this.finished = true;
            }

            return data;
        }
        @Override
        public int available() throws IOException {
            return this.sourceStream.available();
        }
        @Override
        public void close() throws IOException {
            super.close();
            this.sourceStream.close();
        }
        @Override
        public boolean isFinished() {
            return this.finished;
        }
        @Override
        public boolean isReady() {
            return true;
        }
        @Override
        public void setReadListener(ReadListener readListener) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 遍历集合 {@code Enumeration}
     */
    private static class CustomizedEnumeration<E> implements Enumeration<E> {

        private Iterator<E> iterator;

        CustomizedEnumeration(Iterator<E> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasMoreElements() {
            return iterator.hasNext();
        }

        @Override
        public E nextElement() {
            return iterator.next();
        }

    }
}