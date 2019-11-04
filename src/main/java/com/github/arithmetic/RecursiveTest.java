/**
 * projectName: utils
 * fileName: RecursiveTest.java
 * packageName: com.github.arithmetic
 * date: 2019-11-01 15:14
 * copyright(c) 2019 http://www.hydee.cn/ Inc. All rights reserved.
 */
package com.github.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 一个整数可以被分解为多个整数的乘积，
 * 例如，6 可以分解为 2x3。
 * 请使用递归编程的方法，为给定的整数 n，找到所有可能的分解（1 在解中最多只能出现 1 次）。
 * 例如，输入 8，输出是可以是 1x8, 8x1, 2x4, 4x2, 1x2x2x2, 1x2x4, ……
 **/
public class RecursiveTest {
    public static void main(String[] args) {
        recursion(10, new ArrayList<>());
    }

    public static void recursion(long total, ArrayList<Long> result) {

        if (total == 1) {
            if (!result.contains(1L)) {
                result.add(1L);
            }
            System.out.println(result);
        } else {
            for (long i = 1; i <= total; i++) {
                if ((i == 1) && result.contains(1L)) {
                    continue;
                }
                ArrayList<Long> newList = (ArrayList<Long>) (result.clone());
                newList.add(Long.valueOf(i));
                if (total % i != 0) {
                    continue;
                }
                recursion(total / i, newList);
            }
        }
    }
}