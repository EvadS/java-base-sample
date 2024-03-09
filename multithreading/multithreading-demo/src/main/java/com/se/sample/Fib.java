package com.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fib extends Thread {

    private static final Logger logger = LogManager.getLogger(Fib.class);

    public int answer;
    private final int x;

    public Fib(int x) {
        this.x = x;
    }

    public static void main(String[] args)throws Exception {
        try {
            Fib f = new Fib(10);
            f.start();
            f.join();
            logger.info("answer:" +  f.answer);
        } catch (Exception e) {
            logger.error("usage: java Fib NUMBER");
        }
    }

    public void run() {
        if (x <= 2)
            answer = 1;
        else {
            try {
                logger.info("x: " + x);
                Fib f1 = new Fib(x - 1);
                Fib f2 = new Fib(x - 2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                answer = f1.answer + f2.answer;
            } catch (InterruptedException ex) {
            }
        }
    }
}
