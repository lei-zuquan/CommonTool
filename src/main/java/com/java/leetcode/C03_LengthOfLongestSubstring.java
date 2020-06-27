package com.java.leetcode;

import java.util.*;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:01 上午 2020/6/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
3. 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class C03_LengthOfLongestSubstring {
    public static void main(String[] args) {
        //String s = "pwwkew";
        //String s = "bbbbb";
        //String s = "abcabcbb";
        String s = "dvdf";
        //String s = "asjrgapa";
        //String s = "";
        //String s = "ckilbkd";
        int maxLength = lengthOfLongestSubstring(s);
        System.out.println("maxLength:" + maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char charV = s.charAt(end);
            if (hashMap.containsKey(charV)) {
                start = Math.max(hashMap.get(charV), start);
            }
            ans = Math.max(ans, end - start + 1);
            hashMap.put(charV, end + 1);
        }

        return ans;
    }


    public static int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();

        int maxSubLength = -1;
        for (int i = 0; i < chars.length; i++) {
            // 如果字符在之前的子串中出现，则更新最大子串长度
            if (list.contains(chars[i] + "")) {
                int size = list.size();
                maxSubLength = size > maxSubLength ? size : maxSubLength;

                int startPos = list.indexOf(chars[i] + "");
                if (startPos == i-1) {
                    list.clear();
                } else {
                    for (int j = startPos; j >= 0; j--) {
                        list.remove(j);
                    }
                }
            }
            list.add(chars[i] + "");
        }
        int size = list.size();
        maxSubLength = size > maxSubLength ? size : maxSubLength;

        return maxSubLength;
    }
}
