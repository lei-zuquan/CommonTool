package com.java.algorithm.tree.test;

import com.java.algorithm.tree.RedBlackTree;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:23 上午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_RedBlackTree {
    public static void main(String[] args) {
        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1, "老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
    }
}
