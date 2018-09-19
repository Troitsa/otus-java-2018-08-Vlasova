package ru.otus.hw_1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * java -cp target/HW_1.jar;C:\Users\Vlasova_R\.m2\repository\com\google\guava\guava\26.0-jre\guava-26.0-jre.jar ru.otus.hw_1.Main
 * */
public class Main {
    private static final int MEASURE_COUNT = 1;

    public static void main(String... args) {
        Collection<Integer> example = new ArrayList<>();
        int min = 0;
        int max = 999_999;
        for (int i = min; i < max + 1; i++) {
            example.add(i);
        }

        List<Integer> result1 = new ArrayList<>();
        Collections.shuffle((List<Integer>) example);
        calcTime(() -> result1.addAll(Lists.reverse((List<Integer>) example)));
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++)
            runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.println("Time spent: " + timeNs + "ns (" + timeNs / 1_000_000 + "ms)");
    }
}
