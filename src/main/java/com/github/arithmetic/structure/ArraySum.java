package com.github.arithmetic.structure;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/27 11:41
 */
public class ArraySum {


    public int sum(int[] arr,int l){
        if (arr.length == l){
            return 0;
        }
        return sum(arr, l + 1) + arr[l];
    }

    public static void main(String[] args) {

    }
}
