package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.se.sample.model.User;

public class App {

    static final Logger rootLogger = LogManager.getRootLogger();

    /**
     * logger for User class
     */
    static final Logger userLogger = LogManager.getLogger(User.class);

    /**
     * this appender write logs to "logs/${appname}.log"
     */
    static final Logger coreAppenderLogger = LogManager.getLogger("coreappender");

    public static void main(String[] args) {
        coreAppenderLogger.info("**********************************");

        User user = new User();
        user.setName("Anakin");
        user.setLastName("Skywalker");
        userLogger.info(user.showMeMessage());
        userLogger.info(user.giveMeASign());

        rootLogger.info("Root Logger: " + user.showMeMessage());

        //debug
        if (rootLogger.isDebugEnabled()) {
            rootLogger.debug("RootLogger: In debug message");
            userLogger.debug("UserLogger in debug");
        }

        try {
            User userNull = null;
            userNull.showMeMessage();

        } catch (NullPointerException ex) {
            userLogger.error("error message: " + ex.getMessage());
            userLogger.fatal("fatal error message: " + ex.getMessage());
        }
    }
}
