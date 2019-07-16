package com.github.design.command;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:40
 */
public class BuyStock implements Order {

    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
