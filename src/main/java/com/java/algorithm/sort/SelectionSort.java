package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 10:51
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    选择排序
    时间复杂度 N^2
    空间复杂度 O(1)
    不稳定排序
    使用场景：基本不用

    选择排序的思想
        第一次从待排序的数据中选出最小的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小元素，
        然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。

不稳定示例
执行结果：
[5, 8, 5, 2, 9]
[2, 8, 5, 5, 9]
[2, 5, 8, 5, 9]
[2, 5, 5, 8, 9]
 */

public class SelectionSort {

    // 选择排序，每次从未排序序列中选择最小的一个进行对比
    public static void sort(Comparable[] arr) {

        for (int time = 0; time < arr.length; time++) {
            int min = time;
            for (int i = time + 1; i < arr.length; i++) {
                if (smaller(arr[i], arr[min])) {
                    min = i;
                }
            }
            swap(arr, time, min);
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
