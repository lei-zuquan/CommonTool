package com.java.algorithm.linear.test;

import com.java.algorithm.linear.Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:22 上午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C11_QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str+" ");
        }

        System.out.println("-----------------------------");
        while (!queue.isEmpty()){
            String result = queue.dequeue();
            System.out.println("出列了元素："+result);
            System.out.println(queue.size());
        }

    }
}
