package com.github.arithmetic.leetcode;

/**
 *
 * reverse-integer
 * 时间限制：1秒 空间限制：32768K 热度指数：8529
 * 本题知识点： 复杂度 leetcode
 *  算法知识视频讲解
 * 题目描述
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * click to show spoilers.
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 *
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/16 17:36
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1234567899));
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/1a3de8b83d12437aa05694b90e02f47a
     *     来源：牛客网
     *
     *     //本体关键点是如何判断溢出。
     *     //推荐解答用的是用long类型存储结果，如果结果大于0x7fffffff或者小于0x80000000就溢出
     *     //我的解法是每次计算新的结果时，再用逆运算判断与上一次循环的结果是否相同，不同就溢出
     */
    public static int reverse(int x) {

        int res = 0;

        while (x != 0){
            //最后一位
            int tail = x % 10;
            int newRes = res * 10 + tail;
            //如果(newRes - tail)/ 10 != res说明产生了溢出
            if ((newRes - tail) / 10 != res){
                return 0;
            }

            res = newRes;

            x = x / 10;
        }

        return res;

    }
}
