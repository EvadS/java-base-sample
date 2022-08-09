package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClass {

    static Logger logger = LogManager.getLogger(TestClass.class);

    public static void main(String[] args) {
        logger.info("Info");
        logger.debug("Debug *********");
    }
}
