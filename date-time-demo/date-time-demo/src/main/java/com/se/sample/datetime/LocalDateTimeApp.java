package com.se.sample.datetime;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeApp {

    final static Logger logger = Logger.getLogger(LocalDateTimeApp.class);

    public static void main(String[] args) {
        createNew();
    }

    private static void createNew() {

        // Секунды и наносекунды равны нулю
        LocalDateTime date1 = LocalDateTime.of(2014, 9, 19, 14, 5);
        // Наносекунды равны нулю
        LocalDateTime date2 = LocalDateTime.of(2014, 9, 19, 14, 5, 20);
        LocalDateTime date3 = LocalDateTime.of(2014, 9, 19, 14, 5, 20, 9);

        LocalDate date = LocalDate.now();
        LocalDateTime date4 = date.atTime(14, 30, 59, 999999);

        LocalTime time = LocalTime.now();
        LocalDateTime date5 = time.atDate(date);

        logger.info(date1);
        logger.info(date2);
        logger.info(date3);
        logger.info(date4);
        logger.info(date5);
    }
}
