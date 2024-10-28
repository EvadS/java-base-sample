package com.se.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final Logger logger = LogManager.getLogger(AppTest.class);

    @Test
    @DisplayName("Simple method should work")
    void demoTestMethod() {
        assertTrue(true);
    }

    /**
     * Log should write only console
     */
    @Test
    @DisplayName("Test log4j")
    void testLog4jConfig() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
}
