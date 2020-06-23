package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 11:28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
    插入排序
    时间复杂度：N^2
    空间复杂度：O(1)
    稳定
    向已排好序的序列插入数据

    使用场景：
        对于基本有序的数组最好用
        插入排序比冒泡排序快一倍
 */

public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int time = 1; time < arr.length; time++) {
            for (int i = time; i > 0; i--) {
                if (smaller(arr[i], arr[i-1])) {
                    swap(arr, i, i-1);
                }
            }
        }
    }

    private static boolean smaller(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
