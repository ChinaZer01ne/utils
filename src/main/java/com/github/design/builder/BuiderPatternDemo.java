package com.github.design.builder;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 13:47
 */
public class BuiderPatternDemo {
    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal  = mealBuilder.prepareVegMeal();

        System.out.println("Veg Meal");
        vegMeal .showItems();
        System.out.println("Total Cost: " +vegMeal .getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
