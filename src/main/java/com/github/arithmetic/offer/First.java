package com.github.arithmetic.offer;
/**
 * 【第一题】
 *
 * 二维数组查找
 *
 * 时间限制：1秒 空间限制：32768K
 * 本题知识点： 查找
 *
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 1,2,8,9
 * 2,4,9,12
 * 4,7,10,13
 * 6,8,11,15
 *
 * @author Zer01ne
 * @since 2019/3/12 20:49
 */
public class First {

    public static void main(String[] args) {
        int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(4, array));
    }

    public static boolean find(int target, int [][] array) {

        if (array == null){
            return false;
        }

        //以右上角为起点（或者左下角）
        int curX = 0;
        int curY = array[0].length - 1;

        while (curX < array.length && curY >= 0){
            if (array[curX][curY] < target){
                curX++;
            }else if (array[curX][curY] > target){
                curY--;
            }else {
                return true;
            }
        }

        return false;
    }
}
