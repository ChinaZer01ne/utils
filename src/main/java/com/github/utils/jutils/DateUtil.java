package com.github.utils.jutils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/15 15:53
 */
public class DateUtil {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     *  LocalDateTime to String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime){
        return localDateTimeToString(localDateTime,DEFAULT_PATTERN);
    }

    /**
     * LocalDateTime to String use customized pattern
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, String pattern){
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * String to LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String date){
        DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return LocalDateTime.parse(date,defaultFormatter);
    }

    /**
     * String to LocalDateTime use customized pattern
     */
    public static LocalDateTime stringToLocalDateTime(String date, String pattern){
        DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date,defaultFormatter);
    }

    /**
     * String to Date
     */
    public static Date stringToDate(String date){
        return localDateTimeToDate(stringToLocalDateTime(date,DEFAULT_PATTERN));

    }


    /**
     * Date to LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date){

        return LocalDateTime.ofInstant(date.toInstant(),ZoneId.systemDefault());

    }
    /**
     * LocalDateTime to Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.toInstant(OffsetDateTime.now().getOffset()));
    }

    /**
     * String to Date use customized pattern
     */
    public static Date stringToDate(String date, String pattern){
        return localDateTimeToDate(stringToLocalDateTime(date,pattern));

    }

    /**
     * Date to String
     */
    public static String dateToString(Date date){
        return localDateTimeToString(dateToLocalDateTime(date),DEFAULT_PATTERN);

    }

    /**
     * Date to String use customized pattern
     */
    public static String dateToString(Date date, String pattern){
        return localDateTimeToString(dateToLocalDateTime(date),pattern);

    }


    private DateUtil(){}


}
