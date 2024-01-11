package com.se.sample;

import com.se.sample.datetime.LocalDateApp;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1986, 9, 1);

        logger.info("день недели: " +localDate.getDayOfWeek());
        logger.info("день в году: " +localDate.getDayOfYear());
        logger.info("месяц: " +localDate.getMonth());
        logger.info("год: " +localDate.getYear());
    }

}
