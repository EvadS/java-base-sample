package com.se.sample.datetime;

import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeApp {

    final static Logger logger = Logger.getLogger(LocalDateApp.class);


    public static void main(String[] args) {
        // ------------------------------- base
        // С часами (0-23) и минутами(0-59)
        LocalTime fiveThirty = LocalTime.of(5, 30);
        // С часами, минутами и секундами(0-59)
        LocalTime noon = LocalTime.of(12, 0, 0);
        // С часами, минутами, секундами и наносекундами(0-999,999,999)
        LocalTime almostMidnight = LocalTime.of(23, 59, 59, 999999);

        logger.info(fiveThirty);
        logger.info(noon);
        logger.info(almostMidnight);
        logger.info("-------------------------------");

        currentTime();

        currentTimeChrono();

    }

    private static void currentTimeChrono() {
        logger.info(" get() ");

        LocalTime now = LocalTime.now();
        int hourAMPM = now.get(ChronoField.HOUR_OF_AMPM); // 0 - 11
        int hourDay = now.get(ChronoField.HOUR_OF_DAY); // 0 - 23
        int minuteDay = now.get(ChronoField.MINUTE_OF_DAY); // 0 - 1,439
        int minuteHour = now.get(ChronoField.MINUTE_OF_HOUR); // 0 - 59
        int secondDay = now.get(ChronoField.SECOND_OF_DAY); // 0 - 86,399
        int secondMinute = now.get(ChronoField.SECOND_OF_MINUTE);// 0 - 59
        long nanoDay = now.getLong(ChronoField.NANO_OF_DAY);//0-86399999999
        int nanoSecond = now.get(ChronoField.NANO_OF_SECOND);//0-999999999

        logger.info("Часы: " + hourAMPM);
        logger.info("Часы: " + hourDay);
        logger.info("Минуты дня: " + minuteDay);
        logger.info("Минуты: " + minuteHour);
        logger.info("Секунды дня: " + secondDay);
        logger.info("Секунды: " + secondMinute);
        logger.info("Наносекунды дня: " + nanoDay);
        logger.info("Наносекунды: " + nanoSecond);
    }

    private static void currentTime() {
        logger.info(" текущее время");
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int nanosecond = now.getNano();

        logger.info("Часы: " + hour);
        logger.info("Минуты: " + minute);
        logger.info("Секунды: " + second);
        logger.info("Наносекунды: " + nanosecond);
    }
}
