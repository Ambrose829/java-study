package com.pika.algorithms.sort;

import java.util.Arrays;

/**
 * @author Pika
 * @create 2020/10/16
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] testArray = {5, 3, 6, 1, 2, 4};
        bubbleSort(testArray, false);
        for (int i : testArray) {
            System.out.print(i);
        }
    }

    public static void bubbleSort(int[] array, boolean asc) {
        if (asc) {
            for (int i = 0; i < array.length; i ++) {
                for (int j = 1; j < array.length - i;  j ++) {
                    if (array[j - 1] > array[j]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        } else {
            for (int i = 0; i < array.length; i ++) {
                for (int j = 1; j < array.length - i;  j ++) {
                    if (array[j - 1] < array[j]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        }

    }
}
