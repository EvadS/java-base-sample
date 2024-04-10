package org.se.sample.forTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService {
    ExecutorService threadPool;

    public MyService(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public void someMethodToTest() {
        if (this.threadPool == null) {
            // if you didn't provide the executor via constructor in the unit test,
            // it will create a real one
            threadPool = Executors.newFixedThreadPool(3);
        }

        //threadPool.execute(...etc etc);

        threadPool.submit(() -> {
            System.out.println("Some action ...");
        });
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        MyService myService = new MyService(executor);

        myService.someMethodToTest();
    }
}

