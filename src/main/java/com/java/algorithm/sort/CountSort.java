package com.java.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 15:21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
  计数排序(最大，取值范围小)
  非比较排序
  桶思想的一种

  计数算法思想：
       创建新数组，数组大小就是可取值的范围大小；
       如果出现0，就在0那个位置加1，如果再出现0，再在0那个位置再加1

       最大但是范围小
               某大型企业数万名员工年龄排序
               如何快速得知高考名次（腾讯面试）
  总结
       计数排序是非比较排序
       适用于特定问题，也就是对源数据有要求
       时间复杂度：O(N+K)
       空间复杂度：O(N+K)
       稳定性：稳定排序
 */
public class CountSort {

    public static void sort(int[] arr) {

        int tongLength = getMaxValue(arr) + 1;
        // 申请计数数组
        int[] count = new int[tongLength];
        int[] result = new int[arr.length];

        // 遍历数组，将数据放入桶中计数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 0, j=0; i < count.length; i++) {
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }

        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
