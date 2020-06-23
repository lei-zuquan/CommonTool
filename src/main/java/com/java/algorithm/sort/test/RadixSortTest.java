package com.java.algorithm.sort.test;

import com.java.algorithm.sort.RadixSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 15:54
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
  基数排序
  非比较排序
  桶思想的一种
  多关键字排序
  时间复杂度 O( N*k)
  空间复杂度 O(N + k)
  稳定排序

  设计思想：
        基数排序属于高级的排序方法，该排序算法是在“桶排序”的基础上所进行的改进


  总结：
       本质上是一种多关键字排序
       有低位优先和高位优先两种
           LSD MDS (Least Significant Digit first) (Most...)
           MSD属于分治的思想
       百度百科的程序有问题
           空间复杂度变高

 */
/*
421,240,115,532,305,430,124
对个位数按桶进行分类，排序
240,430,421,532,124,115,305
对十位数按桶进行分类，排序
305,115,421,124,430,532,240
对百位数按桶进行分类，排序
115,124,240,305,421,430,532
 */
public class RadixSortTest {

    public static void main(String[] args) {
        int[] arr = {421,240,115,532,305,430,124};

        int[] result = RadixSort.radixSort(arr);
        // 第一步，应该先求最高位数

        System.out.println(Arrays.toString(result));
    }
}
