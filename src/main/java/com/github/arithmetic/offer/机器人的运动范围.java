package com.github.arithmetic.offer;

/**
 *
 * 机器人的运动范围
 * 时间限制：1秒 空间限制：32768K 热度指数：167973
 *  算法知识视频讲解
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/14 13:19
 */
public class 机器人的运动范围 {

    public static void main(String[] args) {
        机器人的运动范围 a = new 机器人的运动范围();
        System.out.println(a.movingCount(15, 20, 20));
    }
    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols ==0){
            return 0;
        }
        int[][] flag = new int[rows][cols]; //走过的或者不可走的即为1
        return isArrival(0,0,threshold,flag);
    }
    //子问题，判断该格子是否可走，可以则返回下一步的4个方位的格子再加上1，否则返回0
    private int isArrival(int i, int j, int threshold, int[][] flag) {
        if (isSatisy(i,j,threshold,flag)){
            flag[i][j] = 1;
            return isArrival(i - 1,j,threshold,flag) + isArrival(i + 1,j,threshold,flag)
                    + isArrival(i,j - 1,threshold,flag) + isArrival(i , j + 1, threshold,flag) + 1;
        }
        return 0;
    }
    //判断格子是否可以走
    private boolean isSatisy(int i, int j, int threshold, int[][] flag) {
        if (i < 0 || j < 0 || i > flag.length - 1 || j > flag[0].length - 1){
            return false;
        }

        if (flag[i][j] == 1){
            return false;
        }

        String s1 = String.valueOf(i);
        String s2 = String.valueOf(j);

        int temp = 0;

        for (int k = 0; k < s1.length(); k++) {
            temp += s1.charAt(k) - '0';
        }
        for (int k = 0; k < s2.length(); k++) {
            temp += s2.charAt(k) - '0';
        }
        return temp <= threshold;
    }
}
