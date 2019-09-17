package com.github.basic;

import java.util.Arrays;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/17 10:18
 */
public class MergeTest {

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0){
            return nums2;
        }
        if (n == 0){
            return nums1;
        }

        int p1 = 0;
        int p2 = 0;
        int index = 0;
        // m + n 其实可能有越界的问题
        int[] merge = new int[m + n];

        while (p1 < m && p2 < n){
            if (nums1[p1] < nums2[p2]){
                merge[index++] = nums1[p1++];
            }else {
                merge[index++] = nums2[p2++];
            }
        }

        while (p1 < m){
            merge[index++] = nums1[p1++];
        }

        while (p2 < n){
            merge[index++] = nums2[p2++];
        }

        return merge;

    }

    public static void main(String[] args) {
        int[] merge = merge(new int[]{8, 6, 5, 4, 1}, 5, new int[]{8, 6,  6, 0}, 4);
        System.out.println(Arrays.toString(merge));
    }
}
