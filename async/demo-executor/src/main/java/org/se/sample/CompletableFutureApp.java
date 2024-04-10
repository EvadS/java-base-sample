package org.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureApp {
    private static final Logger logger = LogManager.getLogger(CompletableFutureApp.class);


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //future исполнится в ForkJoinPool.commonPool()
        // supplyAsync, принимает Supplier,  возвращает значение
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> ("Hi"));
        logger.info(future.get());

        //указать где будет исполняться future то передаем Executor вторым параметром.
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
                () -> "Hi", Executors.newCachedThreadPool());
        logger.info(future.get());

        //runAsync() - принимает Runnable  ничего не возвращает
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("Hi"));

        CompletableFuture<Void> runFuture2 = CompletableFuture
                .runAsync(() -> System.out.println("Hi"), Executors.newCachedThreadPool());
        logger.info("---------------------------------");

        //Получение результата
        CompletableFuture<String> futureValue = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);         // имитируем долгое выполнение
            } catch (InterruptedException e) {}
            return "Hi";
        });
        System.out.println(futureValue.get()); //output Hi
        logger.info("---------------------------------");

        logger.info("Call back function demo ");
        // Добавление callback
        CompletableFuture<String> futureCallBack = CompletableFuture.supplyAsync(() -> "Hi");
        futureCallBack.thenAccept(result -> System.out.println(result));
//        get() вызывается для того, чтобы подождать исполнения future.
        future.get();
        logger.info("---------------------------------");

        /// Добавление нескольких callback
        logger.info("several call back function demo ");
        future = CompletableFuture.supplyAsync(() -> "Hi");

        //thenApply() исполняется в том же потоке, где вызывается.
        // если же использовать  thenApplyAsync(), тогда функция будет исполнена как отдельная задача в ForkJoinPool.commonPool .
        future.thenApply(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });

        future.thenApply(result -> {
            System.out.println(result + ", world!"); //output Hi, world!
            return result;
        });

        future.get();

        ///функция будет исполнена как отдельная задача в ForkJoinPool.commonPool .
        future = CompletableFuture.supplyAsync(() -> "Hi");

        future.thenApplyAsync(result -> {
            System.out.println(result + " all"); //output Hi all
            return result;
        });

        Thread.sleep(100);
    }
}
