package com.pika.designPattern.strategy.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

    public static <T> void sort(T[] array, Comparator comparator) {
        Arrays.sort(array, comparator);
    }
}
