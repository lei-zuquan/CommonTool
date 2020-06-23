package com.java.algorithm.sort.test;

import com.java.algorithm.sort.ShellSort;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 12:34
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class ShellSortTest {
    public static void main(String[] args) {
        Integer[] arr = {2,1,5,6,3,4};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
