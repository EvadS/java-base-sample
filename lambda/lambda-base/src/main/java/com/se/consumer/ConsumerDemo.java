package com.se.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        extracted();
        System.out.println("-------------------------");

        Consumer<Phone> consumer1 =  phone -> System.out.println("Продали телефон: " + phone);
        Consumer<Phone> consumer2 =  phone -> System.out.println("Отправили телефон: " + phone);

        Phone iphone = new Phone("06711111", "iphone", 7);
        consumer1.andThen(consumer2).accept(iphone);

        System.out.println("-------------------------");
        Exam exam = new Exam("name", "version");
        Consumer<Exam> consumerExam =  phone -> System.out.println("Exam: " + exam);
        consumerExam.accept(exam);

    }


    private static void extracted() {
        Consumer<String > printUppercase = str -> System.out.println(str.toUpperCase());
        printUppercase.accept("hello");
    }


}
