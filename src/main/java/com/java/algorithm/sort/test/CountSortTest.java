package com.java.algorithm.sort.test;

import com.java.algorithm.sort.CountSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 15:50
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class CountSortTest {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1,10,7};
        CountSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
