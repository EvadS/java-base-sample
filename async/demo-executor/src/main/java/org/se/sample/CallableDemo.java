package org.se.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CallableDemo {
    private static final Logger logger = LogManager.getLogger(CallableDemo.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demoCallable();

        demoCompletableFuture();

        completableFutureChainDemo();

        demoCompletableFuture3();

        // how to combine
        CompletableFuture.completedFuture(2L)
                .thenCompose((val) -> CompletableFuture.completedFuture(val + 2))
                .thenAccept(result -> System.out.println(result));


        List<String> array = Arrays.asList("one", "two");

        Stream<String> stringStream = array.stream().map(value -> {
            logger.info("Executed");
            return value.toUpperCase();
        });

        logger.info("bye");
    }


    private static void demoCompletableFuture3() throws ExecutionException, InterruptedException {

        Supplier newsSupplier = () -> NewsService.getMessage();

        CompletableFuture<String> reader = CompletableFuture.supplyAsync(newsSupplier);
        CompletableFuture.completedFuture("!!")
                .thenCombine(reader, (a, b) -> b + a)
                .thenAccept(result -> System.out.println(result))
                .get();
    }

    /**
     * цепочка выполнения асихронных запросов
     */
    private static void completableFutureChainDemo() {

        // CompletalbeFuture в своей работе использует Runnable
        AtomicLong longValue = new AtomicLong(0);
        Runnable task = () -> longValue.set(new Date().getTime());
        Function<Long, Date> dateConverter = (longvalue) -> new Date(longvalue);
        Consumer<Date> printer = date -> {
            System.out.println(date);
            System.out.flush();
        };

        // CompletableFuture computation
        //ти стадии будут выполнены в новом потоке.
        CompletableFuture.runAsync(task)
                .thenApply((v) -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer);
    }

    /**
     * класс для асинхронной работы, который дает возможность комбинировать шаги обработки, соединяя их в цепочку.
     * sence Java 1.8
     */
    private static void demoCompletableFuture() {

        // new CompletableFuture that is already completed with the given value.
        CompletableFuture<String> completed = CompletableFuture.completedFuture("Просто значение");

        // CompletableFuture, запускающий (run) новый поток с Runnable, поэтому он Void
        // простой запус Runnable
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            logger.info("run " + Thread.currentThread().getName());
        });

        // CompletableFuture, запускающий новый поток, результат которого возьмём у Supplier
        // as a Runnable, but with result
        CompletableFuture<String> supplier;
        supplier = CompletableFuture.supplyAsync(() -> {
            logger.info("supply " + Thread.currentThread().getName());
            return "Значение";
        });

    }

    /**
     * как использовать Callable
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void demoCallable() throws InterruptedException, ExecutionException {

        Callable task = () -> {
            return "Hello, World!";
        };

        //Task, который будет выполнен во будущем.
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        // в момент получения результата при помощи метода get выполнение становится синхронным.
        String message = future.get();
        logger.info(message);
    }


    /**
     * некий сервис, который получает какое-то сообщение откуда-то и на это требуется время:
     */
    public static class NewsService {
        public static String getMessage() {
            try {
                Thread.sleep(3000);
                return "Message";
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }


}
