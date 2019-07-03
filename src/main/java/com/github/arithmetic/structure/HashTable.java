package com.github.arithmetic.structure;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/3 16:06
 */
public class HashTable<K,V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(initCapacity);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff)% M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){



        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (treeMap.containsKey(key)){
            treeMap.put(key, value);
        }else {
            treeMap.put(key, value);
            size++;

            if (size >= M * upperTol){
                resize(2 * M);
            }
        }
    }

    public V remove(K key){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (treeMap.containsKey(key)){
            size--;

            if (size < M * lowerTol && M / 2 >= initCapacity){
                resize(M / 2);
            }

            return treeMap.remove(key);
        }
    }

    private void resize(int newM) {
        TreeMap[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> treeMap = hashtable[i];
            for (Map.Entry<K,V> entry:
                 treeMap.entrySet()) {
                newHashTable[hash(entry.getKey())].put(entry.getKey(),entry.getValue());
            }
        }
    }

    public void set(K key, V value){
        TreeMap<K, V> treeMap = hashtable[hash(key)];
        if (!treeMap.containsKey(key)) {
            throw new IllegalArgumentException("key doesn't exist!");
        }
        treeMap.put(key,value);
    }

    public boolean contains(K key){
        return  hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }
}
