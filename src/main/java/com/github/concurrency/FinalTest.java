package com.github.concurrency;

public class FinalTest {
    public static void main(String[] args) {

        final int[] array = new int[]{1,2,3};

        array[0] = 5;
        //array = null;

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
