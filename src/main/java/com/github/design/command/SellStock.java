package com.github.design.command;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:41
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }
    @Override
    public void execute() {
        abcStock.sell();
    }
}