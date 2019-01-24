package com.github.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 10:59
 * @Version 1.0
 */
public class ListOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        //for (int i = 0; i < list.size(); i++) {
        //    if (i == 1){
        //        list.remove(0);
        //    }else {
        //        System.out.println(i);
        //    }
        //}
        int index = 0;
        //在下次checkForComodification之前跳出循环，就不会报错
        for (Integer integer :
            list) {

            if (index == 0){
                //什么时候会抛出并发修改的异常呢？
                //注意这时候，modCount和期望修改数已经不一致了，会抛出并发修改异常，所以下面必须break

                list.remove(index);

                System.out.println(integer);
                //如果没有break，在下次循环的时候（调用迭代器的next方法），进行修改数检查，会发现不一致，则会抛异常
                break;
            }else {
                System.out.println(integer);
            }
            index++;
        }
    }
}
