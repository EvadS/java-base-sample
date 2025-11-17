package com.se.demo2;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {



    public static void main(String[] args) throws Exception {
        // demo1();        
        // demo2();
        demo3();
    }

    private static void demo3() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(16);

        Callable<String> task = () -> {
            Thread.sleep(1);
            return "Done";
        };

        // добавляем в очередь на выполнение 10 тыс. заданий
        List<Future<String>> futures = IntStream.range(0, 10_000)
                .mapToObj(i -> service.submit(task))
                .collect(Collectors.toList());

        System.out.printf("На выполнение отправлено %d заданий.%n", futures.size());

        // пробуем закрыть
        service.shutdown();

        // ждем окончания работы 100 миллисекунд
        if (service.awaitTermination(100, TimeUnit.MILLISECONDS)) {
            System.out.println("Все задания выполнены!");
        } else {
            // принудительно останавливаем
            List<Runnable> notExecuted = service.shutdownNow();
            System.out.printf("Так и не запустилось %d заданий.%n", notExecuted.size());
        }

        System.out.printf("Всего выполнено %d заданий.%n", futures.stream().filter(Future::isDone).count());
    }

    private static void demo2() throws InterruptedException {

        // awaitTermination
        // метод блокирует нить, которая его вызвала. Блокировка прерывается, как только наступает
        // любое из трех событий:
        // * после вызова метода shutdown() все активные задания и все задания из очереди были выполнены;
        // * закончился таймаут, длительность которого определяется параметрами метода;
        // * нить, вызвавшая метод awaitTermination(), была прервана.

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> System.out.println("task 1"));
        service.submit(() -> System.out.println("task 2"));
        service.submit(() -> System.out.println("task 3"));
        service.shutdown();
        System.out.println(service.awaitTermination(1, TimeUnit.MICROSECONDS));
    }


    /*
void shutdown() — после вызова этого метода ExecutorService больше не принимает новые задания.
 Все задания, которые раннее были переданы в ExecutorService, продолжат свое выполнение.
 */
    private static void demo1() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> System.out.println("task 1"));
        service.submit(() -> System.out.println("task 2"));
        service.shutdown();
        // здесь произойдет RejectedExecutionException
        service.submit(() -> System.out.println("task 3"));
    }
}
