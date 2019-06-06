package com.github.arithmetic.offer;

/**
 *
 *
 * 数组中的逆序对
 * 时间限制：2秒 空间限制：32768K 热度指数：319109
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * 7
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/5 15:29
 */
public class 数组中的逆序对 {

    /** 思路：前面一个数字大于后面的数字是逆序对，那我们求后面有多少数字小于前面的数字，归并排序的思路可以解决*/
    public static int InversePairs(int [] array) {
        if (array == null || array.length < 2){
            return 0;
        }
        return reverseOrderNum(array,0,array.length - 1) %1000000007;
    }

    private static int merge(int[] array, int L, int R, int mid){
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R -L + 1];
        int cur = 0;
        int totalCount = 0;
        while (p1 <= mid && p2 <= R){

            //从小到大归并
            if (array[p1] < array[p2]){
                help[cur++] = array[p1++];
            }else if (array[p1] > array[p2]){
                help[cur++] = array[p2++];
                totalCount = (totalCount + (mid - p1 + 1))%1000000007;
            }else {
                help[cur++] = array[p1++];
            }

            //从大到小归并也可以
            //if (array[p1] < array[p2]){
            //
            //    //help[cur++] = array[p1++];
            //    help[cur++] = array[p2++];
            //}else if (array[p1] > array[p2]){
            //    //help[cur++] = array[p2++];
            //    help[cur++] = array[p1++];
            //    count++;
            //    totalCount = totalCount + (R - p2 + 1);
            //}else {
            //    help[cur++] = array[p1++];
            //}


        }

        while (p1 <= mid){
            help[cur++] = array[p1++];
        }

        while (p2 <= R){
            help[cur++] = array[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            array[L++] = help[i];
        }



        return totalCount;
    }

    private static int reverseOrderNum(int[] array, int L, int R){
        if (L >= R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);

        //左边逆序对 + //右边逆序对 + //合并
        return reverseOrderNum(array,L,mid) %1000000007  + reverseOrderNum(array,mid + 1,R) %1000000007 + merge(array,L,R,mid);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{8,7,6,5,4,3,2,1};
        System.out.println(InversePairs(arr));
    }
}
