package com.java.algorithm.sort.test;

import com.java.algorithm.sort.SelectionSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 11:01
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        Integer[] arr = {2,1,5,6,3,4};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
