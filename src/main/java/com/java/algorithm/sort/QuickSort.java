package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 14:50
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
    快速排序
 快速排序

 时间复杂度：
 最好的情况：发生在整个数组被分成两段长度相等的子数组时，递推式如下：4,1,3,2,6,5,7
 O(1)   n=1
 T(n) =  2T(n/2) + O(n)  n>1
 T(n) = O(N * logN) 【最优】

 最坏的情况：待排序的序列为正序或者逆序，每次划分只得到一个比上一次划分少一个记录的子序列：1,2,3,4
 O(1)   n=1
 T(n) =  T(n-1) + O(n)  n>1
 T(n) = O( N^2) 【最差】避免最差，先判断是否已经排好序；随机取一个数，放到数组最后，再进行快排

 平均时间复杂度：T(n)=O(N * log2N)，快速排序是一种不稳定的排序算法

 空间复杂度：
 O(log2N)

 稳定性：
 不稳定


 快速排序核心思想：
 每次都取数组的倒数第一个元素作为基准元素，凡是大于这个基准元素的都放在它的右边，凡是小于这个基准元素的都放在它的左边，具体步骤如下：
 1、设置两个变量left 和 right（也称为哨兵），令序列倒数第一个元素为基准元素。
 2、left 指向序列的最左边，right 指向序列的最右边，right从右往左试探，left从左往右试探，直到right找到小于基准的数就停止，left 找到大小基准的数就停止，
 交换left 和 right 指向的两个数， right继续住左试探，left继续往右试探
 3、如果left 与 right相遇，则 left 上的元素与基准元素交换，则这一轮排序结束。
 对基准元素两边的序列重复以上操作。

 bug问题查找思路：
 1、通读程序
 2、输出中间值
 3、剪功能（缩小定位）

 双轴快排：
 1 4 6 【9】 10 2 【3】 5 8 7
 双轴快排就是我们找两个数，把整个数组分成三个区域，当然还有那些正在处理的那个区域
 再把三个区域比第一个数小的放左边，大于等于第一个数小于等于第二个数的放中间；大于第二个数放右边

 DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);

 具体流程：
 数组本身一小块儿一小块儿排的比较好，归并；
 数组比较短插入
 然后双轴快排：
 快排如果有取五个数相等的单轴，不相等的双轴

 1、先判断数组长度是否小于286（小数组）直接使用原始、古老的sort排序；
 2、判断是否适合使用TimSort(归并排序升级)
 3、如果不适合使用归并则使用快排代替

 荷兰国旗问题
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int left, int rightBound) {
        if (left >= rightBound) {
            return;
        }

        int mid = partition(arr, left, rightBound);

        quickSort(arr,0, mid-1);
        quickSort(arr, mid+1, rightBound);
    }

    private static int partition(Comparable[] arr, int left, int rightBound) {
        int right = rightBound - 1;
        Comparable pivot = arr[rightBound]; // pivot 存放基准数
        // 左右下标分别从左、从右向中间移动，如果左边发现有数比rightBound大则停止；如果右边发现有数比rightBound小则停止

        while (left <= right) {
            // 左边
            while (left <= right && arr[left].compareTo(pivot) <= 0) {
                left++;
            }

            // 右边
            while (left <= right && arr[right].compareTo(pivot) > 0) {
                right--;
            }

            // 如果发现，则交换两者的位置
            if (left <= right) {
                swap(arr, left, right);
            }
        }

        // 最后将left与rightBound互换位置，完成本轮快排
        swap(arr, left, rightBound);

        return left;
    }


    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
