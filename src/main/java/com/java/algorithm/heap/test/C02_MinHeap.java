package com.java.algorithm.heap.test;

import com.java.algorithm.heap.MinHeap;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:12 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_MinHeap {

    public static void main(String[] args) {
        heapShow();
    }

    private static void heapShow() {
        MinHeap<Integer> heap = new MinHeap<Integer>(20);
        heap.insert(1);
        heap.insert(2);
        heap.insert(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(6);
        heap.insert(7);
        Integer del;
        while ((del = heap.delMin()) != null) {
            System.out.print(del + ",");
        }
    }
}
