package com.se.demo;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//Создаем ExecutorService на 2 потока
        java.util.concurrent.ExecutorService executorService = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        //Создаем 5 задач
        MyRunnable task1 = new MyRunnable();
        MyRunnable task2 = new MyRunnable();
        MyRunnable task3 = new MyRunnable();
        MyRunnable task4 = new MyRunnable();
        MyRunnable task5 = new MyRunnable();

        final List<MyRunnable> tasks = List.of(task1, task2, task3, task4, task5);

        //Отправляем на обработку список, который содержит 5 ранее созданных задач
        final List<Future<Void>> futures = executorService.invokeAll(tasks, 6, TimeUnit.SECONDS);
        System.out.println("результат в виде списка Future, before shutdown()");

        //Останавливаем ExecutorService
        executorService.shutdown();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("executorService.isShutdown():  " + executorService.isShutdown());
        System.out.println("executorService.isTerminated():" + executorService.isTerminated());
    }

    public static class MyRunnable implements Callable<Void> {


        /*
        Каждая задача выполняется по 5 секунд.
         */
        @Override
        public Void call() {

            // Добавляем 2 задержки времени. При остановке ExecutorService увидим какая из них отрабатывает при попытке остановить выполнение задачи
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("sleep 1: " + e.getMessage());
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("sleep 2: " + e.getMessage());
            }
            System.out.println("done");
            return null;
        }
    }
}