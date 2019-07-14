package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/25 11:50
 */
public class ArrayConvert {

    public static void main(String[] args) {
        Object[] arr = new Object[10];
        //Integer[] arrInt = (Integer[])arr;
        //不能转换
        Integer[] arrInt = (Integer[])new Object[10];
        Convert<Integer> convert = new Convert<>();


        convert.add(1);
        Integer integer = convert.get(0);
        System.out.println(integer);

        //for (int i = 0; i < convert.arr.length; i++) {
        //
        //    System.out.println(arr[i]);
        //
        //}
    }


}

class Convert<T>{
    public T[] arr;

    public Convert(){
        arr = (T[]) new Object[10];
    }

    public void add(T data){
        arr[0] = data;
    }

    public T get(int index){
        return arr[index];
    }
}
