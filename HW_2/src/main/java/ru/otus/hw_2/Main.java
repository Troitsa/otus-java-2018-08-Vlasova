package ru.otus.hw_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ObjectMeasurer objectSizeMeasurer = new ObjectMeasurer();

        long objectSize;

        System.out.println("=====Objects measurement=====");

        Supplier<Object> obj = () -> new Object();
        objectSize = objectSizeMeasurer.measure(obj);
        System.out.println("Object: " + objectSize + " byte");

        Supplier<Object> String = () -> new String(new char[0]);
        objectSize = objectSizeMeasurer.measure(String);
        System.out.println("String: " + objectSize + " byte");

        Supplier<Object> emptyArray = () -> new int[0];
        objectSize = objectSizeMeasurer.measure(emptyArray);
        System.out.println("Array[0]: " + objectSize + " byte");

        Supplier<Object> array = () -> new int[100];
        objectSize = objectSizeMeasurer.measure(array);
        System.out.println("Array[100]: " + objectSize + " byte");

        Supplier<Object> arrayList = () -> new ArrayList<>();
        objectSize = objectSizeMeasurer.measure(arrayList);
        System.out.println("ArrayList: " + objectSize + " byte");

        Supplier<Object> hashset = () -> new HashSet<>();
        objectSize = objectSizeMeasurer.measure(hashset);
        System.out.println("Hashset: " + objectSize + " byte");


        System.out.println("==============================");
    }
}
