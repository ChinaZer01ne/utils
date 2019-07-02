package com.github.arithmetic.structure;

/**
 * 求排序后相邻两数的最大差值
 * @Author: Zer01ne
 * @Date: 2019/1/10 16:43
 * @Version 1.0
 */
public class MaxGap {




    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};
        System.out.println(maxGap(arr));
    }

    private static int maxGap(int[] arr){
        //首先求数组的最大最小值，建立桶
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
             max = Math.max(arr[i],max);
             min = Math.min(arr[i],min);
        }
        if (max == min){
            return 0;
        }
        //建立桶
        boolean[] hasNums = new boolean[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        int bid = 0;
        for (int i = 0; i < arr.length; i++) {
            //当前数在桶中的位置
            bid = bucket(arr[i],arr.length,min,max);
            //没有元素的话，最大值就是当前元素
            maxs[bid] = hasNums[bid] ? Math.max(arr[i],maxs[bid]) : arr[i];
            mins[bid] = hasNums[bid] ? Math.min(arr[i],mins[bid]) : arr[i];

            hasNums[bid] =true;
        }

        int res = 0;
        int lastMax = maxs[0];

        for (int i = 1; i <= arr.length; i++) {
            if (hasNums[i]){
                res = Math.max( res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int num, int length, int min, int max) {

        return ((num - min) * length / (max - min) );
    }
}
