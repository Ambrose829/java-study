package com.pika.algorithms.sort;

import java.util.Arrays;

/**
 * @author Pika
 * @create 2020/10/16
 * @since 1.0.0
 * 冒泡排序
 *
 *  1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *  2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 *  3.针对所有的元素重复以上的步骤，除了最后一个。
 *  4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 从数组的开始开始遍历，
 *  第一次遍历确定最大/最小的值，将其放在一边
 *  第二次遍历确定第二大/小的值，按顺序紧靠最大/最小的值
 *  依此类推。。。
 *
 *  时间复杂度  O(n) ~ O(n²)
 *  空间复杂度  O(1)
 *
 *
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] testArray = {5, 3, 6, 1, 2, 4};
        bubbleSort(testArray, false);
        for (int i : testArray) {
            System.out.print(i);
        }
        bubbleSort(testArray);
        System.out.println();
        for (int i : testArray) {
            System.out.print(i);
        }
    }


    //默认不填则为升序
    public static void bubbleSort(int[] array) {
        bubbleSort(array, true);
    }

    //第二个参数asc代表所需要排的顺序 为true则为升序， 为false则为降序
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
