package com.github.java8.stream;



import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/16 15:29
 */
public class Java8TmieTest {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getYear() +", " + date.getMonthValue() +", " + date.getDayOfMonth());

        System.out.println("=========");

        LocalDate localDate = LocalDate.of(2017, 3, 3);
        System.out.println(localDate);

        MonthDay monthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        System.out.println(monthDay);
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2000, 3, 3));
        System.out.println(monthDay.equals(monthDay1));

        System.out.println("=========");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println(localTime.plusHours(3));

        System.out.println("=========");
        System.out.println(localDate.plus(2, ChronoUnit.WEEKS));

        System.out.println("=========");

        System.out.println(localDate.minus(2, ChronoUnit.MONTHS));


        System.out.println("=========");


        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());


        LocalDate now = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2019, 3, 3);
        System.out.println(now.isAfter(localDate1));
        System.out.println(now.isBefore(localDate1));
        System.out.println(now.equals(localDate1));

        System.out.println("=========");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new TreeSet<String>(){
            {
                addAll(availableZoneIds);
            }
        };

        treeSet.stream().forEach(System.out::println);
        System.out.println("=========");

        System.out.println(YearMonth.now());
        System.out.println(YearMonth.now().lengthOfMonth());
        System.out.println(YearMonth.now().lengthOfYear());
        System.out.println(YearMonth.now().isLeapYear());


        System.out.println("=========");

        Date nowDate = new Date();
        System.out.println(nowDate);

        LocalDate nowLocalDate = LocalDate.now();
        System.out.println(nowLocalDate);
        LocalDateTime nowLocalTime = LocalDateTime.now();
        System.out.println(nowLocalTime);
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(nowLocalTime);
        System.out.println(format);

        System.out.println("=========");
        LocalDateTime dateTime = LocalDateTime.now(Clock.systemUTC());
        System.out.println(dateTime);
    }
}
