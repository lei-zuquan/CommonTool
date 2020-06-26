package com.java.algorithm.tree.test;

import com.java.algorithm.linear.Queue;
import com.java.algorithm.tree.BinaryTree;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:16 上午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.getValue(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());

        System.out.println(bt.min());
        System.out.println(bt.max());

        // 前序遍历
        System.out.println("// 前序遍历");
        preErgodicTest();

        // 中序遍历
        System.out.println("// 中序遍历");
        midErgodicTest();

        // 后序遍历
        System.out.println("// 后序遍历");
        afterErgodicTest();

        // 层序遍历
        System.out.println("// 层序遍历");
        layerErgodicTest();

        // 树的最大深度
        System.out.println("// 树的最大深度");
        maxDepthTest();
    }

    private static void preErgodicTest() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        Queue<String> queue = tree.preErgodic();

        for (String key : queue) {
            System.out.println(key+"="+tree.get(key));
        }
    }

    private static void midErgodicTest() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        Queue<String> queue = tree.midErgodic();

        for (String key : queue) {
            System.out.println(key+"="+tree.get(key));
        }
    }

    private static void afterErgodicTest() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        Queue<String> queue = tree.afterErgodic();

        for (String key : queue) {
            System.out.println(key+"="+tree.get(key));
        }
    }

    private static void layerErgodicTest() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        Queue<String> queue = tree.layerErgodic();

        for (String key : queue) {
            System.out.println(key+"="+tree.get(key));
        }
    }

    private static void maxDepthTest() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        int maxDepth = tree.maxDepth();

        System.out.println("最大深度：" + maxDepth);
    }
}
