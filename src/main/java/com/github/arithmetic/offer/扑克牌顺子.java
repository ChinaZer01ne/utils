package com.github.arithmetic.offer;



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

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/762836f4d43d43ca9deb273b3de8e1f4
     * 来源：牛客网
     *
     * max 记录 最大值
     * min 记录  最小值
     * min ,max 都不记0
     * 满足条件
     *         1 除0外没有重复的数字(牌)
     *         2  max - min <5
     *         3 数组长度 为5
     *
     * */
    public boolean isContinuous(int [] numbers) {

        if (numbers == null || numbers.length < 5){
            return false;
        }

        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0){
                continue;
            }
            //说明一张牌（忽略花色）出现了多次
            if (d[numbers[i]] > 1){
                return false;
            }
            //记录最大最小值
            if (numbers[i] > max){
                max = numbers[i];
            }
            if (numbers[i] < min){
                min = numbers[i];
            }
        }
        //满足同样的牌出现一次（忽略花色）
        if (max - min < 5){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        扑克牌顺子 a = new 扑克牌顺子();
        //System.out.println(a.isContinuous(new int[]{1, 3, 2, 5, 4}));
        System.out.println(a.isContinuous(new int[]{0,3,2,6,4}));
    }
}
