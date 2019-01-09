package com.github.arithmetic.sort;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/2 15:05
 * @Version 1.0
 */
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        chooseSort(arr);
        printArr(arr);
    }

    private static void chooseSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        chooseSort(arr,0,arr.length);
    }

    private static void chooseSort(int[] arr, int left, int right) {
        for (int i = left; i < right - 1; i++) {
            int min = i;
            for (int j = i + 1; j < right; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            if (min != i){
                swap(arr,i,min);
            }

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArr(int[] arr){
        for (int i:
                arr) {
            System.out.print(i + "\t");
        }
    }
}

