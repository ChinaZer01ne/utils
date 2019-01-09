package com.github.arithmetic.sort;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/7 10:44
 * @Version 1.0
 */
public class QuickSort {

    private static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }


    private static void quickSort(int[] arr, int L, int R) {
        if (L < R){
            swap(arr,L + (int) (Math.random() * (R -L + 1)),R);
            int[] p = partation(arr, L, R);
            quickSort(arr,L,p[0] - 1);
            quickSort(arr,p[1] + 1,R);
        }
    }

    private static int[] partation(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more){
            if (arr[L] < arr[R]){
               swap(arr,++less,L++);
            }else if (arr[L] > arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,R,more);
        return new int[]{less + 1,more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        quickSort(arr);
        printArr(arr);
    }
    private static void printArr(int[] arr){
        for (int i:
                arr) {
            System.out.print(i + "\t");
        }
    }
}
