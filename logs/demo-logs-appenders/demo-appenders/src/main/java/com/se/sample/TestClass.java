package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClass {

    /**
     * VM param on startup
     * -Dlog4j.configurationFile=/home/softkit/Documents/projects/Learning/java-base-sample/logs/demo-logs-appenders/demo-appenders/src/main/resources/log4j.properties
     */
    static Logger logger = LogManager.getLogger(TestClass.class);

    public static void main(String[] args) {
        for(int i =50; i>0; i--) {
            logger.info("Info {}", i);
            logger.debug("Debug *********{}",i);
        }

        logger.info("FINISHED ====================");
    }
}
