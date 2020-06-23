package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 11:14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    冒泡排序
    时间复杂度N^2
    空间复杂度O(1)
    使用场景：基本不用，时间复杂度太高

    排序思想：
         比较相邻的元素。如果第一个比第二个大，就交换他们两个。
         对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
         针对所有的元素重复以上的步骤，除了最后一个。
         持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

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
