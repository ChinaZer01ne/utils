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
        for (Integer integer :
            list) {

            if (index == 1){
                list.remove(index);
                System.out.println(integer);
            }else {
                System.out.println(integer);
            }
            index++;
        }
    }
}
