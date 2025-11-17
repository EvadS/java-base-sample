package com.se.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // firstVersion();

        secondScenario();

    }

    private static void secondScenario() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future future = service.submit(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed");
            }
        });

        // метод get насмерть блокирует текущий поток и будет ждать пока фоновый не завершится
        future.get();
    }

    private static void firstVersion() {
        //  «выстрелил и забыл»,
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed");
            }

            @Override
            public String toString() {
                return super.toString();
            }
        });

        System.out.println("main thread is finished");
    }
}
