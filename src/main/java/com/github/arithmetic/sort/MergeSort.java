package com.github.arithmetic.sort;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/7 9:46
 * @Version 1.0
 */
public class MergeSort {
    private static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if (L == R){
            return;
        }
        int mid = L + ((R -L) >> 1);
        mergeSort(arr,L,mid);
        mergeSort(arr,mid + 1,R);
        merge(arr,L,R,mid);
    }

    private static void merge(int[] arr, int L, int R, int mid) {
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L + 1];
        int i = 0;
        while (p1 <= mid && p2 <= R){
            if (arr[p1] < arr[p2]){
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L++] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        mergeSort(arr);
        printArr(arr);
    }
    private static void printArr(int[] arr){
        for (int i:
                arr) {
            System.out.print(i + "\t");
        }
    }
}
