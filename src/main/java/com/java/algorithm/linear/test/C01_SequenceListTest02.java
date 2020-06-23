package com.java.algorithm.linear.test;

import com.java.algorithm.linear.SequenceList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:42 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_SequenceListTest02 {
    public static void main(String[] args) {
        SequenceList<String> sequence = new SequenceList<>(5);
        //测试遍历
        sequence.insert("姚明");
        sequence.insert("科比");
        sequence.insert("麦迪");
        sequence.insert("艾佛森");
        sequence.insert("卡特");
        sequence.insert("55");
        for (String s : sequence) {
            System.out.println(s);
        }
    }
}
