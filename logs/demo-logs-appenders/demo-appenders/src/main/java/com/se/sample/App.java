package com.se.sample;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {
    static final Logger rootLogger = LogManager.getRootLogger();
    static final Logger userLogger = LogManager.getLogger(User.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");

        User user = new User();
        user.setName("Anakin");
        user.setLastName("Skywalker");

        userLogger.info(user.showMeMessage());
        userLogger.info(user.giveMeASign());

        rootLogger.info("Root Logger: "  + user.showMeMessage());

        //debug
        if (rootLogger.isDebugEnabled()) {
            rootLogger.debug("RootLogger: In debug message");
            userLogger.debug("UserLogger in debug");
        }

        try {
            User userNull = new User();
            userNull.getName().toString();
        } catch (NullPointerException ex) {
            userLogger.error("error message: " + ex.getMessage());
            userLogger.fatal("fatal error message: " + ex.getMessage());
        }



    }
}
