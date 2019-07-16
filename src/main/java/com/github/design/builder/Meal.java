package com.github.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个 Meal 类，带有上面定义的 Item 对象。
 *
 * 套餐
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:43
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.println("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }

}
