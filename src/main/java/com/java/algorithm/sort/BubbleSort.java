package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 11:14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class BubbleSort {
    public static void sort(Comparable[] arr){
        for (int endPos = arr.length-1; endPos > 0; endPos--) {
            for (int i = 1; i <= endPos; i++) {
                if (greater(arr[i-1], arr[i])) {
                    swap(arr, i-1, i);
                }
            }
        }
    }

    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
