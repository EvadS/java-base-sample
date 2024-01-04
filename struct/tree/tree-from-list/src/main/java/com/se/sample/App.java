package com.se.sample;

import org.apache.log4j.Logger;

/**
 * Hello world!
 */
public class App {

    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        Tree mt = new Tree();
        mt.add(new Book(4,"A"));
        mt.add(new Book(3,"B"));
        mt.add(new Book(2,"C"));
        mt.add(new Book(3,"D"));
        mt.add(new Book(1,"E"));
        mt.add(new Book(4,"F"));
        mt.add(new Book(1,"G"));
        mt.add(new Book(2,"H"));
        mt.add(new Book(8,"X"));
        mt.add(new Book(7,"Y"));

        logger.info(mt.toString());

        System.out.println("Hello World!");
    }
}
