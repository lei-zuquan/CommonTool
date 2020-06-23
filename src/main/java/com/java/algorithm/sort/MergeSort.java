package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 12:47
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 归并排序
 TIM SORT
 JAVA 对象排序专用
 （前提是知道 两个数据已经排好序，使用递归方法）

 重新分配与原空间等长

 整个数组分成2半
 两个排好序的子数组【】 【】
 分成两半

 归并时间复杂度：
 O(N * logN)

 空间复杂度：
 O(n)

 稳定性：稳定

 应用场景：
 java、python对象排序应用非常多，要求稳定
 对象排序一般要求稳定
 java对象排序使用都是归并排序

 TimSort（优化后的对象排序，如果面试中回复了此排序，对面试官印象大增）（Arrays.sort(Object) 1440行）
 TimSort 是改进中的 MergeSort 归并排序（用到了插入排序（二分插入排序），也用到了归并排序）
 一下分很多块，两两归并，两两归并

 归并排序设计思想：
 1、首先将数组分成两半，两个数组已经排好序，首先把数据分成两半；
 2、如果两半中没有排好序，再分成两半，直至排好序
 3、分配新数组，长度与原数组等长（两个子数组从头开始一一对比，小的放下来，数组下标后移1位）
 4、最后，需要判断剩余数未移动下来新数组
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid + 1, right);

    }

    private static void merge(Comparable[] arr, int leftPrt, int rightPtr, int rightBound) {
        int left = leftPrt;
        int right = rightPtr;
        int leftBound = rightPtr - 1;

        // 申请新数组
        Comparable[] result = new Comparable[rightBound - leftPrt + 1];
        // 完成数组索引
        int finishIndex = 0;

        while (left <= leftBound && right <= rightBound) {
            // 先判断左边的数
            while (left <= leftBound && right <= rightBound && arr[left].compareTo(arr[right]) <= 0) {
                result[finishIndex++] = arr[left++];
            }

            // 再判断右边的数
            while (left <= leftBound && right <= rightBound && arr[left].compareTo(arr[right]) > 0) {
                result[finishIndex++] = arr[right++];
            }
        }

        // 经过上述后，有可能左边有剩余、也可能右边有剩余
        while (left <= leftBound) {
            result[finishIndex++] = arr[left++];
        }

        while (right <= rightBound) {
            result[finishIndex++] = arr[right++];
        }

        // 将归并好的数据放回原数组中
        for (int i = 0; i < result.length; i++) {
            arr[leftPrt + i] = result[i];
        }
    }
}
