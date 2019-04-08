package com.github.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 13:05
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        conditionFilter(list, p -> p > 5);

        System.out.println("=================");

        conditionFilter(list, p -> p % 2 == 0);

        System.out.println("=================");

        conditionFilter(list, p -> p % 2 != 0);

        System.out.println("=================");

        conditionFilter(list, p -> true);

        System.out.println("=================");

        conditionFilter(list, p -> false);

        System.out.println("=================");

        conditionFilter2(list, p -> p > 5, p -> p % 2 == 0);
        conditionFilter(list, p -> p > 5 &&  p % 2 == 0);

        System.out.println("=================");

        System.out.println(isEquals("test").test("test"));

    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer i : list) {
            if (predicate.test(i)){
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void conditionFilter2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        for (Integer i : list) {
            if (predicate1.and(predicate2).test(i)){
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static Predicate<String> isEquals(Object o){
        return Predicate.isEqual(o);
    }

}
