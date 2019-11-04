package com.github.basic;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;

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

        //LocalDate localDate = LocalDate.parse(String.valueOf(201910), DateTimeFormatter.ofPattern("yyyyMM"));
        YearMonth parse = YearMonth.parse(String.valueOf(201910),DateTimeFormatter.ofPattern("yyyyMM"));
        YearMonth yearMonth = parse.plusMonths(3);
        String yyyyMM = yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM"));
        //LocalDate.parse(String.valueOf(201910), DateTimeFormatter.ofPattern("yyyyMM"));
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
        //Date parse = sdf.parse(String.valueOf(201910));
        //LocalDateTime localDateTime = LocalDateTime.parse(String.valueOf(201910), DateTimeFormatter.ofPattern("yyyyMM"));
        //LocalDateTime nextLocalDate = localDateTime.plusMonths(1);
        //System.out.println(nextLocalDate);
        //System.out.println(localDate);
        System.out.println(parse);
        System.out.println(yyyyMM);
        //LocalDateTime.of(LocalDate.of(2019,10,1),null);
        LocalDate localDate2 = LocalDate.of(2019,11,3);
        LocalDate localDate1 = LocalDate.of(2019,12,30);
        long timestamp1 = localDate1.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        long timestamp2 = localDate2.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        System.out.println(timestamp2);
        System.out.println(timestamp1);
    }

}
