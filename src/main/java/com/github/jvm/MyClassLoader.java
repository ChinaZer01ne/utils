package com.github.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    private String classLoaderName;
    private String path;
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
        //如果父类加载器加载了类，那么这些是不会输出的
        System.out.println("findClass invoke " + name);
        System.out.println("class loader name " + classLoaderName);
        byte[] bytes = loadClassData(name);

        return this.defineClass(null,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name){

        InputStream in = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] data = null;

        name = name.replace(".","\\");
        try {
            in = new FileInputStream(new File(this.path + name + extName));

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


    public static void test(ClassLoader classLoader) throws Exception{

    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        //如果两个类加载器需要自己加载类，并且没有层级关系，那么每个类加载器会在自己的命名空间中加载一次
        MyClassLoader classLoader = new MyClassLoader("load1");
        classLoader.setPath("C:\\Users\\Ninee\\Desktop\\");
        Class<?> aClass = classLoader.loadClass("com.github.jvm.MyTest");
        System.out.println(aClass.hashCode());
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println(o);
        System.out.println(o.getClass().getClassLoader());

        //类的卸载
        classLoader = null;
        aClass = null;
        o = null;
        System.gc();
        Thread.sleep(100000);

        MyClassLoader classLoader2 = new MyClassLoader(classLoader,"load2");
        classLoader2.setPath("C:\\Users\\Ninee\\Desktop\\");
        Class<?> aClass2 = classLoader2.loadClass("com.github.jvm.MyTest");
        System.out.println(aClass2.hashCode());
        Object o2 = aClass2.getDeclaredConstructor().newInstance();
        System.out.println(o2);
        System.out.println(o2.getClass().getClassLoader());


    }
}
