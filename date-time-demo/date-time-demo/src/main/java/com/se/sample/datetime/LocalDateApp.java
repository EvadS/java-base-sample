package com.se.sample.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.apache.log4j.Logger;

public class LocalDateApp {

    final static Logger logger = Logger.getLogger(LocalDateApp.class);

    public static void main(String[] args) {

        LocalDate newYear2001 = LocalDate.of(2001, 1, 1);
        logger.info(newYear2001);

        LocalDate newYear2002 = LocalDate.of(2002, Month.JANUARY, 1);
        logger.info(newYear2002);
        logger.info("is " + newYear2001 + " after " + newYear2002 + " :" + newYear2001.isAfter(newYear2002));

        LocalDate today = LocalDate.now();
        logger.info("today: " + today);
        int year = today.getYear();
        int month = today.getMonthValue();
        Month monthAsEnum = today.getMonth(); // как перечисление
        int dayYear = today.getDayOfYear();
        int dayMonth = today.getDayOfMonth();
        DayOfWeek dayWeekEnum = today.getDayOfWeek(); // как перечисление

        System.out.println("Год: " + year);
        System.out.println("Месяц: " + month);
        System.out.println("Название месяца: " + monthAsEnum);
        System.out.println("День в году: " + dayYear);
        System.out.println("День месяца: " + dayMonth);
        System.out.println("День недели: " + dayWeekEnum);

        System.out.println("*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*");
        year = today.get(ChronoField.YEAR);
        month = today.get(ChronoField.MONTH_OF_YEAR);
        dayYear = today.get(ChronoField.DAY_OF_YEAR);
        dayMonth = today.get(ChronoField.DAY_OF_MONTH);
        int dayWeek = today.get(ChronoField.DAY_OF_WEEK);

        System.out.println("Год: " + year);
        System.out.println("Месяц: " + month);
        System.out.println("День в году: " + dayYear);
        System.out.println("День месяца: " + dayMonth);
        System.out.println("День недели: " + dayWeek);

        logger.info("   использование методов with()    ");
        newYear2001 = LocalDate.of(2001, 1, 1);

        LocalDate newYear2003 = newYear2001.with(ChronoField.YEAR, 2003);
        LocalDate newYear2004 = newYear2001.withYear(2004);
        LocalDate december2001 = newYear2001.withMonth(12);
        LocalDate february2001 = newYear2001.withDayOfYear(32);
        LocalDate xmas2001 = newYear2001.withMonth(12).withDayOfMonth(25);

        logger.info("newYear2003 " + newYear2003);
        logger.info("newYear2004 " + newYear2004);
        logger.info("december2001 " + december2001);
        logger.info("february2001 " + february2001);
        logger.info("xmas2001 " + xmas2001);

        logger.info("Методы plus(), minus()");
        LocalDate newYear2005 = newYear2001.plusYears(4);
        LocalDate march2001 = newYear2001.plusMonths(2);
        LocalDate january15Year2001 = newYear2001.plusDays(14);
        LocalDate lastWeekJanuary2001 = newYear2001.plusWeeks(3);
        LocalDate newYear2006 = newYear2001.plus(5, ChronoUnit.YEARS);

        LocalDate newYear2000 = newYear2001.minusYears(1);
        LocalDate nov2000 = newYear2001.minusMonths(2);
        LocalDate dec30Year2000 = newYear2001.minusDays(2);
        LocalDate lastWeekDec2001 = newYear2001.minusWeeks(1);
        LocalDate newYear1999 = newYear2001.minus(2, ChronoUnit.YEARS);

        logger.info("newYear2005: " + newYear2005);
        logger.info("march2001: " + march2001);
        logger.info("january15Year2001: " + january15Year2001);
        logger.info("lastWeekJanuary2001: " + lastWeekJanuary2001);
        logger.info("newYear2006: " + newYear2006);

        logger.info("newYear2000: " + newYear2000);
        logger.info("nov2000: " + nov2000);
        logger.info("dec30Year2000: " + dec30Year2000);
        logger.info("lastWeekDec2001: " + lastWeekDec2001);
        logger.info("newYear1999: " + newYear1999);
    }


}
