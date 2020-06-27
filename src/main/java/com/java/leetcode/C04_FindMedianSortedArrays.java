package com.java.leetcode;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:17 下午 2020/6/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*

4. 寻找两个正序数组的中位数

给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C04_FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {5,6,7,8};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = merge(nums1, nums2);
        System.out.println(Arrays.toString(merge));

        int length = merge.length;
        if (length % 2 == 0) {
            int mid2 = length / 2;
            int mid1 = mid2-1;
            return (merge[mid1] + merge[mid2]) / 2.0;
        } else {
            int mid = length / 2;
            return merge[mid];
        }
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int total = arr1.length + arr2.length;
        int[] newArr = new int[total];

        int leftIndex = 0;
        int rightIndex = 0;
        int finishIndex = 0;
        while (leftIndex + rightIndex <= total - 1) {
            if (leftIndex < arr1.length && rightIndex < arr2.length) {
                if (arr1[leftIndex] <= arr2[rightIndex]) {
                    newArr[finishIndex++] = arr1[leftIndex++];
                } else {
                    newArr[finishIndex++] = arr2[rightIndex++];
                }
            } else if (leftIndex < arr1.length && rightIndex == arr2.length) {
                newArr[finishIndex++] = arr1[leftIndex++];
            } else if (rightIndex < arr2.length && leftIndex == arr1.length) {
                newArr[finishIndex++] = arr2[rightIndex++];
            }
        }

        return newArr;
    }
}
