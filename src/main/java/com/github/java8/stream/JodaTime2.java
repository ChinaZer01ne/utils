package com.github.java8.stream;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;


/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/16 15:15
 */
public class JodaTime2 {
    public static void main(String[] args) {
        System.out.println(JodaTime2.convertUTC(new Date()));
    }

    private static Date convert(String utcDate){

        try {
            DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return dateTime.toDate();
        } catch (Exception e) {
            return null;
        }
    }

    private static String convertUTC(Date date){
        DateTime dateTime = new DateTime(date,DateTimeZone.UTC);
        return dateTime.toString();
    }

    private static String convertDate2LocalByDateFormat(Date javaDate, String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }
}
