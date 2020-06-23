package com.java.algorithm.linear.test;

import com.java.algorithm.linear.SequenceList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:49 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_SequenceListTest03 {
    public static void main(String[] args) {
        SequenceList<String> sequence = new SequenceList<>(5);
        //测试遍历
        sequence.insert(0, "姚明");
        sequence.insert(1, "科比");
        sequence.insert(2, "麦迪");
        sequence.insert(3, "艾佛森");
        sequence.insert(4, "卡特");
        System.out.println(sequence.capacity());
        sequence.insert(5,"aa");


        System.out.println(sequence.capacity());
        sequence.insert(5,"aa");
        sequence.insert(5,"aa");
        sequence.insert(5,"aa");
        sequence.insert(5,"aa");
        sequence.insert(5,"aa");
        System.out.println(sequence.capacity());
        sequence.remove(1);
        sequence.remove(1);
        sequence.remove(1);
        sequence.remove(1);
        sequence.remove(1);
        sequence.remove(1);
        sequence.remove(1);
        System.out.println(sequence.capacity());
    }
}
