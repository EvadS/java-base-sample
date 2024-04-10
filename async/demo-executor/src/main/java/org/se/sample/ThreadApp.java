package org.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Hello world!
 */
public class ThreadApp {
    private static final Logger logger = LogManager.getLogger(ThreadApp.class);

    public static void main(String[] args) {
        //каждый новый запуск  его придётся повторять
        Runnable task2 = () -> {
            System.out.println("Task executed");
        };
        Thread thread = new Thread(task2);
        thread.start();

        logger.info("------------------------------------");
        info();
        logger.info("------------------------------------");


        // свой обработчик ошибок
        Thread th = Thread.currentThread();
        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Возникла ошибка: " + e.getMessage());
            }
        });

        System.out.println(2/0);
        //------------------------

        sleepDemo();


    }

    /**
     * Засыпание потока
     */
    private static void sleepDemo() {
        Runnable task = () -> {
            try {
                int secToWait = 1000 * 60;
                Thread.currentThread().sleep(secToWait);
                ///TimeUnit.SECONDS.sleep(60);
                logger.info("Waked up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private static void  interruptThread(){
        Runnable task = () -> {
            while(!Thread.currentThread().isInterrupted()) {
                //Do some work
            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }

    private static void info() {

        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println("Thread: " + currentThread.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Parent Group: " + threadGroup.getParent().getName());
    }


}
