package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * VM param on startup
 * -Dlog4j.configurationFile=conf/log4j2-text.properties
 * this appender use only file out put
 */
public class App2 {
    static Logger logger = LogManager.getLogger(App2.class);

    public static void main(String[] args) {

        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");

        for(int i =50; i>0; i--) {
            logger.info("Info {}", i);
            logger.debug("Debug *********{}",i);
        }

        logger.info("FINISHED ====================");
    }
}
