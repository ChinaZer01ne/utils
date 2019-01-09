package com.github.arithmetic.sort;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/2 13:53
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        bubbleSort(arr);
        printArr(arr);
    }

    private static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        bubbleSort(arr,0,arr.length);
    }

    private static void bubbleSort(int[] arr, int left, int right) {
        for (int end = right - 1; end > 0; end--) {
            for (int i = left; i < end; i++){
                if (arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                }
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
