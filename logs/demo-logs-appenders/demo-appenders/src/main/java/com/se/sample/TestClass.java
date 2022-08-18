package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClass {

    static Logger logger = LogManager.getLogger(TestClass.class);

    public static void main(String[] args) {
        for(int i =1000; i>0; i--) {
            logger.info("Info {}", i);
            logger.debug("Debug *********");
        }

        logger.info("FINISHED ====================");
    }
}
