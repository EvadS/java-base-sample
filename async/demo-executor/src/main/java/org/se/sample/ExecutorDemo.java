package org.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class ExecutorDemo {

    private static final Logger logger = LogManager.getLogger(ExecutorDemo.class);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        base1();
        base2();
        scheduledExecutorServiceDemo();

        base01();
    }

    private static void base01() throws ExecutionException, InterruptedException {
        /*
            создали сам обьект ExecutorService и вызвали на нём метод execute. Передав в него самую обычную имплементацию потока
         */

        //ExecutorService is a JDK API that simplifies running tasks in asynchronous mode
        ExecutorService service = Executors.newFixedThreadPool(3);
        //выстрелил и забыл» - ничего не возвращает
        service.execute(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed");
            }
        });

        service.shutdown();

        /*
        ExecutorService service1 = Executors.newSingleThreadExecutor();
        ExecutorService service2 = Executors.newFixedThreadPool(3);
        ExecutorService service3 = Executors.newScheduledThreadPool(3);
         */

        //возвращает объект интерфейса Future.
        Future future = service.submit(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed");
            }
        });

        future.get();

//-----------------------------------------------------
        //из фонового потока возвратить данные в текущий.
        future = service.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Another thread was executed");
                return "result";
            }
        });

        System.out.println("Result: " + future.get());

    }

    private static void  scheduledExecutorServiceDemo() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };
        scheduledExecutorService.schedule(task, 1, TimeUnit.MINUTES);
        scheduledExecutorService.shutdown();
    }

    private static void base2() throws ExecutionException, InterruptedException {
        Callable<String> task = () -> Thread.currentThread().getName();
        // за ExecutorService прячется блокирующая очередь,
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future result = service.submit(task);
            System.out.println(result.get());
        }
        //  в противном случае наша программа не завершится.
        service.shutdown();
    }

    private static void base1() {

        Runnable task = () -> {
            System.out.println("Task executed");
        };
        Thread thread = new Thread(task);
        thread.start();

        Runnable task2 = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task2);
    }
}
