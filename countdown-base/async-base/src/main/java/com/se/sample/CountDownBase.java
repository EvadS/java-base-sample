package com.se.sample;

import java.util.concurrent.*;

public class CountDownBase {

    public void demo1() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(8);


        int tasks = 16;

        CountDownLatch latch = new CountDownLatch(tasks);
        for (int i = 0; i < tasks; i++) {
            Future<?> future = pool.submit(() -> {
                try {
                    //задача
                    System.out.println("i++++");
                } finally {
                    latch.countDown();
                }
            });
        }
        if (!latch.await(2, TimeUnit.SECONDS)){
// Обработка времени ожидания

        }
    }
}
