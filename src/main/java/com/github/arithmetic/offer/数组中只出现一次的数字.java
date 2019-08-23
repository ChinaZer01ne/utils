package com.github.arithmetic.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数组中只出现一次的数字
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：195317
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author Zer01ne
 * @since 2019/3/26 21:51
 */
public class 数组中只出现一次的数字 {

    /**
     *
     * 位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     *
     * */
    public static void main(String[] args) {

    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array == null){
            return;
        }

        Map<Integer,Boolean> map = new HashMap<>();
        //这个标志法换成用数字记录出现次数更好
        for (int i = 0; i < array.length; i++) {

            Boolean aBoolean = map.get(array[i]);

            if (aBoolean != null){
                map.put(array[i], false);
            }else {
                map.put(array[i], true);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (Map.Entry entry:
             map.entrySet()) {
            Boolean value = (Boolean) entry.getValue();
            if (value){
                result[i] = (int) entry.getKey();
                i++;
            }
        }
        num1[0] = result[0];
        num2[0] = result[1];
    }

    //异或法 TODO
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {


        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            // 剩余的两数一定会走不同的逻辑，因为之前找1，就说明在该位置，两数是不同的
            // 相同的数也会分到一起，异或最后剩下的就是要找的
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    /**
     * 从右边数第一个1出现的位置
     */
    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
