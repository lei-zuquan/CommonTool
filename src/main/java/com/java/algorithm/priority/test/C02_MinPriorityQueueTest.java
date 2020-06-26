package com.java.algorithm.priority.test;

import com.java.algorithm.priority.MinPriorityQueue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:30 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_MinPriorityQueueTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MinPriorityQueue<String> minPq = new MinPriorityQueue<>(20);

        for (String s : arr) {
            minPq.insert(s);
        }
        System.out.println(minPq.size());
        String del;
        while (!minPq.isEmpty()) {
            del = minPq.delMin();
            System.out.print(del + ",");
        }
    }
}
