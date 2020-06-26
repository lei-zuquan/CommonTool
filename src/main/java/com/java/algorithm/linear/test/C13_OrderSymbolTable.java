package com.java.algorithm.linear.test;

import com.java.algorithm.linear.OrderSymbolTable;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:01 上午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C13_OrderSymbolTable {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> bt = new OrderSymbolTable<>();
        bt.put(4, "二哈");
        bt.put(3, "张三");
        bt.put(1, "李四");
        bt.put(1, "aa");
        bt.put(5, "王五");


        Iterator<Integer> iterator = bt.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
