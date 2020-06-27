package com.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:43 下午 2020/6/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
5. 最长回文子串

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C05_LongestPalindrome {
    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int maxLength = 0;
        String sub = "";
        for (int i = 0; i < chars.length; i++) {

            if (list.contains(chars[i]) && list.size() > maxLength) {

                sub = "";
                int startPos = list.indexOf(chars[i]);

                maxLength = list.size() - startPos +1;

                for (int i1 = startPos; i1 < list.size(); i1++) {
                    sub = sub + list.get(i1);
                }
                sub = sub + chars[i];
                if (list.size() > 0 && chars[i] == list.get(0) && i != chars.length - 1) {

                } else {
                    list.clear();
                }

            }
            list.add(chars[i]);
        }

        if (!sub.equals("") && list.size() > 0) {
            int lastMaxLength = list.size();
            if (lastMaxLength > maxLength) {
                sub = "";
                for (int i1 = 0; i1 < list.size(); i1++) {
                    sub = sub + list.get(i1);
                }
            }
            return sub;
        } else if (chars.length > 0){
            return chars[0] + "";
        } else {
            return "";
        }

    }
}
