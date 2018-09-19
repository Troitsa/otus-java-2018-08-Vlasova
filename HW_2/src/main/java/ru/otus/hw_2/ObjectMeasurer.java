package ru.otus.hw_2;

import java.util.function.Supplier;

public class ObjectMeasurer {
    private int count = 1000;

    private void garbage_clear() {
        try {
            System.gc();
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private long memorySize() {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        return totalMemory - freeMemory;
    }

    public long measure(Supplier<Object> obj) {
        long startMemory, finishMemory;
        Object[] array = new Object[count];
        garbage_clear();
        startMemory = memorySize();
        for (int i = 0; i < count; i++) {
            array[i] = obj.get();
        }
        garbage_clear();
        finishMemory = memorySize();
        return (finishMemory - startMemory) / count;
    }
}
