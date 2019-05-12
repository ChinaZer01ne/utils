package com.github.arithmetic.offer;
/**
 *
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 时间限制：1秒 空间限制：32768K 热度指数：173805
 * 本题知识点： 模拟
 *  算法知识视频讲解
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1
 *
 *
 * @author Zer01ne
 * @since 2019/5/12 14:33
 */
public class 圆圈中最后剩下的数 {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(10, 3));
    }
    public static int LastRemaining_Solution(int n, int m) {

        boolean[] childs = new boolean[n];

        int curNum = 1;
        int findCount = 0;

        for (int i = 0; i < n; i++) {

            if (findCount == n){
                return i - 1;
            }
            if (!childs[i]){

                if (curNum == m){
                    findCount++;
                    childs[i] = true;
                    curNum = 0;
                }
                curNum++;
            }

            if (i + 1 == n){
                i = -1;
            }
        }
        return -1;
    }

}
