package com.java.leetcode;

import java.util.*;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:00 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C01_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    // 时间复杂度O(n^2)
    public static int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            for (int j = i+1; j< nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    set.add(i);
                    set.add(j);
                }
            }
        }

        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) ) {
                Integer index = hashMap.get(target - nums[i]);
                if (index == i) {
                    continue;
                }
                int[] res = {i, index};
                return res;
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) ) {
                Integer index = hashMap.get(target - nums[i]);
                if (index == i) {
                    continue;
                }
                if (i < index) {
                    int[] res = {i, index};
                    return res;
                } else {
                    int[] res = {index, i};
                    return res;
                }

            }

            hashMap.put(nums[i], i);
        }
        return null;
    }
}
