package com.github.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String classLoaderName;
    private final String extName = ".class";

    protected MyClassLoader(String classLoaderName) {
        super();    //父加载器是系统加载器
        this.classLoaderName = classLoaderName;
    }

    protected MyClassLoader(ClassLoader parent,String classLoaderName) {
        super(parent);  //父加载器是自己指定的
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassData(name);

        return this.defineClass("custom",bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name){

        InputStream in = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] data = null;
        try {
            String loadClassName = name.replaceAll("/", ".") + extName;
            in = new FileInputStream(new File(loadClassName));

            int ch = 0;
            while ((ch = in.read()) != -1){
                bout.write(ch);
            }
            data = bout.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bout.close();
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return data;
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", extName='" + extName + '\'' +
                '}';
    }

    public static void test(ClassLoader classLoader) throws Exception{
        Class<?> aClass = classLoader.loadClass("com.github.jvm.MyTest");
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println(o);
    }
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("load1");
        test(classLoader);
    }
}
