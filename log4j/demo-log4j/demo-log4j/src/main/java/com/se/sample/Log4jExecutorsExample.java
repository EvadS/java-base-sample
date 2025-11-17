package com.se.sample;



import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Log4jExecutorsExample {

//    private static final Logger logger = LogManager.getLogger(Log4jExecutorsExample.class);
    final static Logger logger = Logger.getLogger(Log4jExecutorsExample.class);

    public static void main(String[] args) throws InterruptedException {

        logger.info("Application started.");

        // Create a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit multiple tasks to the executor
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                logger.debug(String.format("Task %s started in thread: %s", taskId, Thread.currentThread().getName()));
                try {
                    // Simulate some work
                    Thread.sleep(100 + (long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    logger.error(String.format("Task %s interrupted: %s", taskId, e.getMessage()));
                    Thread.currentThread().interrupt();
                }
                logger.debug(String.format("Task %s finished in thread: %s", taskId, Thread.currentThread().getName()));
            });
        }

        // Shut down the executor and wait for tasks to complete
        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            logger.warn("Executor did not terminate in time. Forcing shutdown.");
            executor.shutdownNow();
        }

        logger.info("Application finished.");
    }
}
