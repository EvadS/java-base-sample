package com.se.sample.period;

import com.se.sample.instant.InstantDemo1;
import org.apache.log4j.Logger;

import java.time.Period;

public class PeriodDemo1 {

    final static Logger logger = Logger.getLogger(PeriodDemo1.class);


    public static void main(String[] args) {
        Period period5y4m3d = Period.of(5, 4, 3);
        Period period2d = Period.ofDays(2);
        Period period2m = Period.ofMonths(2);
        Period period14d = Period.ofWeeks(2);
        Period period2y = Period.ofYears(2);

        logger.info(period5y4m3d);
        logger.info(period2d);
        logger.info(period2m);
        logger.info(period14d);
        logger.info(period2y);
    }
}
