package com.github.arithmetic.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 数组中重复的数字
 * 时间限制：1秒 空间限制：32768K 热度指数：237675
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 示例1
 * 输入
 * 复制
 * 输出
 * 复制
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/6 17:30
 */
public class 数组中重复的数字 {



    /**
     * 思路：
     *链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8
     * 来源：牛客网
     *
     * 此大法利用了哈希的特性，但不需要额外的存储空间。 因此时间复杂度为O(n)，不需要额外空间！
     *
     * 把当前序列当成是一个下标和下标对应值是相同的数组；
     * 遍历数组，判断当前位的值和下标是否相等：
     * 2.1. 若相等，则遍历下一位；
     * 2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！若不等，则将它们两交换。
     *      换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
     *
     * */
    public boolean duplicateWithoutExtra(int numbers[],int length,int [] duplication) {


        if ( numbers==null ) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( numbers[i]<0 || numbers[i]>length-1 ) {
                return false;
            }
        }

        // key step
        for( int i=0; i<length; i++ ){
            while( i!=numbers[i] ){
                if ( numbers[i] == numbers[numbers[i]] ) {
                    duplication[0] = numbers[i];
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[numbers[i]] = temp;
            }
        }

        return false;
    }






    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {


        Map<Integer,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(numbers[i],map.get(numbers[i]) == null ? 1 : map.get(numbers[i]) + 1);
        }

        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            if(entry.getValue() > 1){
                duplication[0] = entry.getKey();
                return true;
            }
        }
        return false;


    }


    public static void main(String[] args) {

        数组中重复的数字 a = new 数组中重复的数字();
        int[] d = new int[1];
        System.out.println(a.duplicate(new int[]{2, 1, 3, 1, 4}, 5, d));
        System.out.println(d[0]);
    }
}
