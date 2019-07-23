package com.github.basic;

import java.util.ArrayList;
import java.util.List;

public class ListAdd {
    public static void main(String[] args) {
        //add(null);
        //System.out.println(list.size());
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        printList(list);

    }

    private static List<Integer> list = new ArrayList<>();
    private static int cur = 0;
    private static void add(Integer ele){
        if (list.size() < 5){
            list.add(ele);
        }else {
            list.set((cur++)%(list.size() + 1),ele);
        }
    }

    private static void printList(List<Integer> list){
        for (Integer i:
             list) {
            System.out.println(i);
        }
    }
}
