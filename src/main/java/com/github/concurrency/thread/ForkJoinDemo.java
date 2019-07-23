package com.github.concurrency.thread;

import java.util.concurrent.RecursiveTask;

/**
 * 还是实现1到一千万的累加和
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/23 11:41
 */
public class ForkJoinDemo {


    private class TaskImpl extends RecursiveTask<Long>{

        //临界值，就是结束值减开始值的结果如果小于这个值那么就不拆分了，大于这个值才会拆分
        private final int MEDIAN_NUM = 100000;
        //从多少计算
        private int startNum = 0;
        //计算到多少
        private int endNum = 0;
        //构造
        public TaskImpl(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        protected Long compute() {

            //结束值减开始值的结果
            int temp = endNum - startNum;
            //判断结束值减开始值的结果是否小于上面定义的临界值
            if (temp <= MEDIAN_NUM){
                //如果小的话，那么就不进行拆分了，就直接调用方法开始计算
                return sequentiallySum();
            }
            //到这就代表结束值减开始值的结果是大于临界值的
            //继续进行拆分
            //startNum到startNum + temp / 2是把数据的左半部分形成一个新的task
            //比如0到10，那么就是 10-0=10，temp=10，startNum=0,所以形成的新task就是(0,10/2=5),也就是左半部分


            return null;
        }

        //计算方法：在不能进行拆分的时候进行计算
        private Long sequentiallySum(){
            long sum = 0;
            for (int i = startNum; i <= endNum; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
