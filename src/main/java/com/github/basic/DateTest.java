package com.github.basic;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/24 14:23
 */
public class DateTest {

    public static void main(String[] args) {
        YearMonth date = YearMonth.of(2019, 4);
        //最后一天
        LocalDate endOfMonth = date.atEndOfMonth();
        LocalDate start = date.atDay(1);
        System.out.println(start);
        System.out.println(endOfMonth);
    }
}
