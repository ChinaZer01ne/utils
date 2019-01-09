package com.github.arithmetic.sort;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/9 14:03
 * @Version 1.0
 */
public class HeapSort {
    private static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {


        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left ;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    private static void heapInsert(int[] arr, int index) {

        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        heapSort(arr);
        printArr(arr);
    }
    private static void printArr(int[] arr){
        for (int i:
                arr) {
            System.out.print(i + "\t");
        }
    }
}
