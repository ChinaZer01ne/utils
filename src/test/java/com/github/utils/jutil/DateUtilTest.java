package com.github.utils.jutil;

import com.github.utils.jutils.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/15 15:53
 */
public class DateUtilTest {

    @Test
    public void testDateUtil() {

        // LocalDateTime to String
        System.out.println("LocalDateTime to String : " + DateUtil.localDateTimeToString(LocalDateTime.now()));
        // Date to LocalDateTime
        System.out.println("Date to LocalDateTime : " + DateUtil.dateToLocalDateTime(new Date()));
        // LocalDateTime to Date
        System.out.println("LocalDateTime to Date : " + DateUtil.localDateTimeToDate(LocalDateTime.now()));
        // String to LocalDateTime
        System.out.println("String to LocalDateTime : " + DateUtil.stringToLocalDateTime("2019-01-01 00:00:00"));
        // String to Date
        System.out.println("String to Date : " + DateUtil.stringToDate("2019-01-01 00:00:00"));
        // Date to String
        System.out.println("String to Date : " + DateUtil.dateToString(new Date()));


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = LocalDate.now();

        String format = date.format(dateTimeFormatter);
        System.out.println(format);
        LocalDate parse = LocalDate.parse(format, dateTimeFormatter);
        System.out.println(parse);


    }
}
