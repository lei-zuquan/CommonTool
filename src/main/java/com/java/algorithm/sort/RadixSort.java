package com.java.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 15:54
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class RadixSort {
    public static int[] radixSort(int[] arr) {
        int[] result = new int[arr.length];

        int[] count = new int[10]; // 0~9 十个数

        for (int time = 0; time < 3; time++) {

            int pow = (int) Math.pow(10, time);

            for (int i = 0; i < arr.length; i++) {
                // 将个数取出来，对个数位进行桶计数
                int mod = arr[i] / pow % 10;
                count[mod]++;
            }

            // 累加数组，数组值对应排序后下标值+1
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 遍历原数组421,240,115,532,305,430,124
            for (int i = arr.length - 1; i >= 0; i--) {
                // 将个数取出来，对个数位进行桶计数
                int mod = arr[i] / pow % 10;
                result[--count[mod]] = arr[i];
            }

            System.out.println("第" + time + " 次基数排序：" + Arrays.toString(count));


            // 将排序好的数组，还原回arr，继续下一位排序
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 清空count计数数组
            Arrays.fill(count, 0);
            System.out.println("第" + time + " 次数组后排序：" + Arrays.toString(arr));
        }


        return result;
    }
}
