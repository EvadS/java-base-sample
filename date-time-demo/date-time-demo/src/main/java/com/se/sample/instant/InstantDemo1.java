package com.se.sample.instant;

import org.apache.log4j.Logger;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstantDemo1 {
    final static Logger logger = Logger.getLogger(InstantDemo1.class);

    /**
     * Instant используется для представления мгновения в секундах, которые прошли с 1 января 1970 года.
     * в наносекундах
     */

    public static void main(String[] args) {
        Instant now = Instant.now();

        Instant instant = now.with(ChronoField.NANO_OF_SECOND, 10);
        // Устанавливаем секунды
        Instant fiveSecondsAfterEpoch = Instant.ofEpochSecond(5);
        // Устанавливаем секунды и наносекунды (могут быть отрицательные)
        Instant sixSecTwoNanBeforeEpoch = Instant.ofEpochSecond(-6, -2);
        // Устанавливаем милисекунды после (могут быть и до) эпохи
        Instant fiftyMilliSecondsAfterEpoch = Instant.ofEpochMilli(50);

        logger.info("now: " + now);
        logger.info("instant: " + instant);
        logger.info("fiveSecondsAfterEpoch: " + fiveSecondsAfterEpoch);
        logger.info("sixSecTwoNanBeforeEpoch: " + sixSecTwoNanBeforeEpoch);
        logger.info("fiftyMilliSecondsAfterEpoch: " + fiftyMilliSecondsAfterEpoch);
    }
}
