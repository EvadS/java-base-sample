package com.se.sample;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;
import java.util.List;

public class MyBenchmark {


    static final int COUNT = 10000;

    @Benchmark
    public List<Boolean> testFillEmptyList() {

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            list.add(Boolean.TRUE);
        }
        return list;
    }


    @Benchmark
    public List<Boolean> testFillAllocatedList() {
        List<Boolean> list = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            list.add(Boolean.TRUE);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
