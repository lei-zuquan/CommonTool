package com.java.algorithm.heap.test;

import com.java.algorithm.heap.HeapSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:25 上午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_HeapSortTest {

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
