package com.github.arithmetic.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 扑克牌顺子
 * 时间限制：1秒 空间限制：32768K 热度指数：188621
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/6 15:41
 */
public class 扑克牌顺子 {

    public boolean isContinuous(int [] ints) {

        //int i = numbers.length;
        //
        //for (int j = 0 ; j < 5 ; j ++){
        //    int random = (int) (Math.random() * i);
        //    swap(numbers, random, i);
        //    i--;
        //}

        //int[] ints = Arrays.copyOfRange(numbers, numbers.length - 6, numbers.length - 1);
        Map<Integer,Integer> zeroMap = new HashMap<>();
        zeroMap.put(0,0);
        Arrays.sort(ints);
        for (int k = 0; k < ints.length - 1;k++){

            if (ints[k] == 0){
                zeroMap.put(0,zeroMap.get(0) + 1);
                continue;
            }

            if (ints[k + 1] != ints[k] + 1){
                if (zeroMap.get(0) > 0 && ints[k + 1] - ints[k] + 1 < 2){
                    zeroMap.put(0,zeroMap.get(0) - 1);
                }else {
                    return false;
                }
            }
        }
        return true;

    }

    private void swap(int[]arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void main(String[] args) {
        扑克牌顺子 a = new 扑克牌顺子();
        //System.out.println(a.isContinuous(new int[]{1, 3, 2, 5, 4}));
        System.out.println(a.isContinuous(new int[]{0,3,2,6,4}));
    }
}
