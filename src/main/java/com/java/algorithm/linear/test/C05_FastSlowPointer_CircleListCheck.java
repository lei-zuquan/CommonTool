package com.java.algorithm.linear.test;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 16:39
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C05_FastSlowPointer_CircleListCheck {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;
        //判断链表是否有环
        boolean circle = isCircle(first);
        System.out.println("first链表中是否有环："+circle);
    }
    /**
     * 判断链表中是否有环
     * @param first 链表首结点
     * @return ture为有环，false为无环
     */
    public static boolean isCircle(Node<String> first) {
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                return true;
            }
        }

        return false;
    }

    private static class Node<T> {
        // 节点数据
        private T item;
        // 下一节点
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
}
