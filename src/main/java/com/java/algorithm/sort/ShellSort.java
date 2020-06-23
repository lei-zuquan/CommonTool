package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 12:28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    希尔排序是一种改进插入排序
    时间复杂度：N^1.3
    空间复杂度：O(1)
    不稳定排序

    排序思想：
    经过一定的间隔，比如中间4个间隔，使用插入排序；然后间隔序列后移一位，再次使用插入排序；直至最后一位；
    缩小间隔，再排一遍。比如为2再排一遍；
    最后以间隔为1再排一遍；

    好处：在数组长度较大时，数据移动次数较少；在数组长度较小时，数据移动距离较短。
    但因希尔排序因为跳着排，所以不稳定

 */
public class ShellSort {
    public static void sort(Comparable[] arr) {
        // Knuth序列
        // h = 1
        // h = 3*h + 1
        int h = 1;
        while (h <= arr.length / 3) {
            h = h*3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap-1)/3) {
            for (int time = gap; time < arr.length; time++) {
                for (int i = time; i-gap >= 0; i-= gap) {
                    if (smaller(arr[i], arr[i-gap])) {
                        swap(arr, i, i-gap);
                    }
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
