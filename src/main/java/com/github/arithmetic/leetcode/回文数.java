package com.github.arithmetic.leetcode;

/**
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 11:28
 */
public class 回文数 {
    /**
     * 不转字符串
     */
    public static boolean isPalindrome(int x) {

        if (x < 0){
            return false;
        }

        if (x > 0 && x < 10){
            return true;
        }

        //首先判断位数
        int copy = x;
        //位数
        int count = 0;
        while (copy != 0){
            copy = copy / 10;
            count++;
        }
        int mid = count / 2;
        int i = 0;
        while (count > mid){
            //如果第一位不等于最后一位
            if ((int)(x / Math.pow(10,count - 1)) != (int)((x % Math.pow(10,1 + i)) / Math.pow(10,i))){
                return false;
            }
            //去掉第一位
            x = (int)(x % Math.pow(10,count - 1));

            count--;
            i++;

        }

        return true;
    }

    public boolean isPalindrome2(int x) {

        if (x < 0){
            return false;
        }

        if (x > 0 && x < 10){
            return true;
        }
        int renew;
        int div = x;
        long res = 0;
        while(div != 0){
            renew = div % 10;
            div = div / 10;
            res = res * 10 + renew;
        }
        return x == res;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
    }
}
