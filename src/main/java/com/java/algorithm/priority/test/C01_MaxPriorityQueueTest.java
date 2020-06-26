package com.java.algorithm.priority.test;

import com.java.algorithm.priority.MaxPriorityQueue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:20 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_MaxPriorityQueueTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPriorityQueue<String> maxPq = new MaxPriorityQueue<>(20);
        for (String s : arr) {
            maxPq.insert(s);
        }

        System.out.println(maxPq.size());
        String del;

        while (!maxPq.isEmpty()) {
            del = maxPq.delMax();
            System.out.print(del + ",");
        }
    }
}
