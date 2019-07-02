package com.github.arithmetic.structure;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 打印链表的公共部分
 * @Author: Zer01ne
 * @Date: 2019/1/17 16:19
 * @Version 1.0
 */
public class PrintLinkCommonPart {

    public static void main(String[] args) {

        LinkedList<Integer> firstList = new LinkedList<>();
        LinkedList<Integer> secondList = new LinkedList<>();

        firstList.add(1);
        firstList.add(5);
        firstList.add(3);
        firstList.add(8);
        firstList.add(7);

        secondList.add(1);
        secondList.add(3);
        secondList.add(3);
        secondList.add(8);
        secondList.add(7);
        secondList.add(9);

        printLinkCommonPart(firstList,secondList);
    }

    private static void printLinkCommonPart(LinkedList<Integer> firstList, LinkedList<Integer> secondList) {
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();

        while (firstIterator.hasNext() && secondIterator.hasNext()){
            Integer first = firstIterator.next();
            Integer second = secondIterator.next();
            if (first.equals(second)){
                System.out.println(first);
            }
        }
    }

}
