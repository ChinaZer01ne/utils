package com.github.arithmetic.structure;

import java.util.HashMap;

/**
 * 设计一种结构，在该结构中有三个功能
 * isnert(key):将某个key加入到该结构，做到结构不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom()：等概率随机返回结构中的key
 * @Author: Zer01ne
 * @Date: 2019/1/29 13:59
 * @Version 1.0
 */
public class RandomPool {

    private static HashMap keyIndexMap = new HashMap();
    private static HashMap indexKeyMap = new HashMap();
    private static Integer size = 0;
    public static void main(String[] args) {
        insert("a");
        insert("b");
        insert("c");
        insert("d");
        insert("e");
        insert("f");
        delete("c");
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
    }
    //将某个key加入到该结构，做到结构不重复加入
    private static void insert(String key){
        keyIndexMap.put(key,size);
        indexKeyMap.put(size,key);
        size++;
    }
    //将原本在结构中的某个key移除
    //先把最后一个填补要删除元素的位置（防止连续空间被破坏），然后删除
    private static void delete(String key){
        if (keyIndexMap.containsKey(key)){
            size--;

            Integer index = (Integer) keyIndexMap.get(key);
            String ele = (String) indexKeyMap.get(size);

            keyIndexMap.remove(indexKeyMap.get(size));
            indexKeyMap.remove(size);

            keyIndexMap.put(ele,index);
            indexKeyMap.put(index,ele);
        }


    }
    //等概率随机返回结构中的key
    private static String getRandom(){
        if (size == 0){
            return null;
        }

        return (String) indexKeyMap.get((int)(Math.random() * size));
    }
}
