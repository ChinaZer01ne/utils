package com.github.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 14:41
 */
public class Broker {

    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
