package com.github.design.command;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:42
 */
public class CommandPatternDemo {
    public static void main(String[] args) {

        Stock abcStock = new Stock();

        //命令
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
