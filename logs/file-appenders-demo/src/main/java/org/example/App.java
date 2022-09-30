package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 **/public class App
{
    static Logger log = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {

        log.info("application stated");
        System.out.println( "Hello World!" );
        for(int i =1; i<=30; i++){
            log.info("working : {}", i);
        }
    }
}