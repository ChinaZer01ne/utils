package com.github.java8.stream;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/16 15:04
 */
public class JodaTime {
    public static void main(String[] args) {

        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        System.out.println("--------------");

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);

        System.out.println("--------------");
        localDate = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate);

        System.out.println("--------------");
        DateTime dateTime = new DateTime();
        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime1.toString("yyyy-MM-dd"));


    }
}
