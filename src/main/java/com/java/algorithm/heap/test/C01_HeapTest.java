package com.java.algorithm.heap.test;

import com.java.algorithm.heap.Heap;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:02 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }
    }
}
