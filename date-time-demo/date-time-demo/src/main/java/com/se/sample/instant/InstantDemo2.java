package com.se.sample.instant;

import org.apache.log4j.Logger;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstantDemo2 {

    final static Logger logger = Logger.getLogger(InstantDemo2.class);

    public static void main(String[] args) {
        Instant now = Instant.now();
        long seconds = now.getEpochSecond(); // Получить секунды
        int nanos1 = now.getNano(); //Получить наносекунды
        // Получить значение как int
        int millis = now.get(ChronoField.MILLI_OF_SECOND);
        // Получить значение как long
        long nanos2 = now.getLong(ChronoField.NANO_OF_SECOND);

        logger.info("Секунды: " + seconds);
        logger.info("Наносекунды: " + nanos1);
        logger.info("Милисекунды: " + millis);
        logger.info("Наносекунды: " + nanos2);
    }
}
