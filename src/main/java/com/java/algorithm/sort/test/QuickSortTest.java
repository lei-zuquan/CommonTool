package com.java.algorithm.sort.test;

import com.java.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 15:09
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class QuickSortTest {
    public static void main(String[] args) {
        Integer[] arr = {2,1,3};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
