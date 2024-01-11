package com.se.sample.duration;

import com.se.sample.instant.InstantDemo1;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationDemo1 {

    /**
     *  Duration служит для хранения продолжительности времени на основе секунд и наносекунд.
     */
    final static Logger logger = Logger.getLogger(DurationDemo1.class);

    public static void main(String[] args) {
        Duration oneDay = Duration.ofDays(1);
        Duration oneHour = Duration.ofHours(1);
        Duration oneMin = Duration.ofMinutes(1);
        Duration tenSeconds = Duration.ofSeconds(10);
        Duration twoSeconds = Duration.ofSeconds(1, 1_000_000_000);
        Duration oneSecondFromMillis = Duration.ofMillis(1);
        Duration oneSecondFromNanos = Duration.ofNanos(1000000000);
        Duration oneSecond = Duration.of(1, ChronoUnit.SECONDS);

        logger.info("oneDay: " + oneDay);
        logger.info("oneHour: " + oneHour);
        logger.info("oneMin: " + oneMin);
        logger.info("tenSeconds: " + tenSeconds);
        logger.info("twoSeconds: " + twoSeconds);
        logger.info("oneSecondFromMillis: "+oneSecondFromMillis);
        logger.info("oneSecondFromNanos: "+oneSecondFromNanos);
        logger.info("oneSecond: "+oneSecond);
    }
}
