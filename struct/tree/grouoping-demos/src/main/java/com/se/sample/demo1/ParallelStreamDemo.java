package com.se.sample.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreamDemo {

    public static void main(String[] args) {

        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbersStream.parallel().reduce((x, y)-> x*y);
        System.out.println(result.get()); // 720

        System.out.println("---------------------------------------------");
        List<String> people = Arrays.asList("Tom","Bob", "Sam", "Kate", "Tim");
        System.out.println("Последовательный поток");
        people.stream().filter(p->p.length()==3).forEach(System.out::println);

        System.out.println("\nПараллельный поток");
        people.parallelStream().filter(p->p.length()==3).forEach(System.out::println);

    }
}
