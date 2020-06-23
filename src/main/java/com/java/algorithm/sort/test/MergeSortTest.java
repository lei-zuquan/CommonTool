package com.java.algorithm.sort.test;

import com.java.algorithm.sort.MergeSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 14:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class MergeSortTest {
    public static void main(String[] args) {
        Integer[] arr = {2,1,5,6,3,4};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
