package com.github.arithmetic.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数组中出现次数超过一半的数字
 * 时间限制：1秒 空间限制：32768K 热度指数：323394
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/6 15:35
 */
public class    数组中出现次数超过一半的数字 {



    /** 思路1：分形叶思想，打擂？
     *
     *      作者：cm问前程
     *          链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
     *          来源：牛客网
     *
     *          采用阵地攻守的思想：
     *          第一个数字作为第一个士兵，守阵地；count = 1；
     *          遇到相同元素，count++;
     *          遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
     *          再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     *
     *     怎么这么牛逼呢？
     * */
    public int MoreThanHalfNum_Solution(int [] array) {

            if(array==null||array.length<=0){
                return 0;
            }

            int length=array.length;

            int result=array[0];
            int times=1;
            for(int i=1;i<length;i++){
                if(times==0){
                    result=array[i];
                    times=1;
                }else{
                    if(array[i]==result){
                        times++;
                    }else{
                        times--;
                    }
                }
            }

            times=0;
            for(int i=0;i<length;i++){
                if(result==array[i]){
                    times++;
                }
            }

            if(times*2<length){
                result=0;
            }
            return result;
    }


    /** 思路2：先排序，如果存在这个数，那么一定是中间的数，然后遍历看看是否超过了数组一半的次数*/
    public int MoreThanHalfNum_Solution2(int [] array) {
        return 0;
    }

    /** 思路3：遍历数组计算出现次数，O（N）*/
    public int MoreThanHalfNum_Solution3(int [] array) {

        if (array.length == 1){
            return array[0];
        }


        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            if (entry.getValue() > array.length / 2){
                return entry.getKey();
            }
        }

        return 0;
    }


    public static void main(String[] args) {

    }
}
