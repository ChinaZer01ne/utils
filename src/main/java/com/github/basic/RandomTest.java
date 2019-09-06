package com.github.basic;

import java.util.Random;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/6 12:05
 */
public class RandomTest {

    private int leftMoney;
    private int leftNum;
    private Random rnd;

    public RandomTest(int total, int num){
        this.leftMoney = total;
        this.leftNum = num;
        this.rnd = new Random();
    }

    public synchronized int nextMoney(){

        if(this.leftNum <= 0){
            throw new IllegalStateException("抢光了");
        }

        if(this.leftNum == 1){
            return this.leftMoney;
        }

        double max = this.leftMoney / this.leftNum * 2d;

        int money = (int)(rnd.nextDouble() * max);

        money = Math.max(1, money);

        this.leftMoney -= money;

        this.leftNum --;

        return money;
    }
}
