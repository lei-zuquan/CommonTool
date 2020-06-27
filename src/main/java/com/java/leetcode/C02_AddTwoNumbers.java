package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:42 下午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class C02_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;

//        ListNode l11 = new ListNode(5);
//        l11.next = null;
//        ListNode l21 = new ListNode(5);
//        l21.next = null;


//        ListNode l11 = new ListNode(0);
//        l11.next = null;
//
//        ListNode l21 = new ListNode(7);
//        ListNode l22 = new ListNode(3);
//        l21.next = l22;
//        l22.next = null;


//        ListNode l11 = new ListNode(9);
//        ListNode l12 = new ListNode(9);
//        l11.next = l12;
//        l12.next = null;
//
//        ListNode l21 = new ListNode(9);
//        l21.next = null;

//        ListNode l11 = new ListNode(1);
//        l11.next = null;
//
//        ListNode l21 = new ListNode(9);
//        ListNode l22 = new ListNode(9);
//        l21.next = l22;
//        l22.next = null;

        ListNode resNode = addTwoNumbers(l11, l21);

        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode currNode = resNode;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int res = sum % 10;
            ListNode newNode = new ListNode(res);
            currNode.next = newNode;
            currNode = currNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            currNode.next = newNode;

        }

        return resNode.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        List<Integer> nodeList1 = getNodeList(l1);
        List<Integer> nodeList2 = getNodeList(l2);

        int size1 = nodeList1.size();
        int size2 = nodeList2.size();
        List<Integer> resList = new ArrayList<>();

        int jinWei = 0;
        if (size1 >= size2) {
            while (nodeList2.size() > 0) {
                Integer v1 = nodeList1.remove(0 );
                Integer v2 = nodeList2.remove(0);
                int sum = v1 + v2 + jinWei;
                jinWei = sum / 10;
                resList.add(sum % 10);
            }
            if (size1 == size2) {
                if (jinWei != 0) {
                    resList.add(jinWei);
                }
            } else {
                while (nodeList1.size() > 0) {
                    Integer v1 = nodeList1.remove(0);
                    int sum = v1 + jinWei;
                    jinWei = sum / 10;
                    resList.add(sum % 10);
                }
                if (jinWei != 0) {
                    resList.add(jinWei);
                }
            }


        } else {
            while (nodeList1.size() > 0) {
                Integer v1 = nodeList1.remove(0);
                Integer v2 = nodeList2.remove(0);
                int sum = v1 + v2 + jinWei;
                jinWei = sum / 10;
                resList.add(sum % 10);
            }
            while (nodeList2.size() > 0) {
                Integer v1 = nodeList2.remove(0);
                int sum = v1 + jinWei;
                jinWei = sum / 10;
                resList.add(sum % 10);
            }

            if (jinWei != 0) {
                resList.add(jinWei);
            }
        }

        ListNode head = null;
        ListNode currNode = null;
        for (int i = 0; i < resList.size(); i++) {
            if (currNode == null) {
                head = new ListNode(resList.get(i));
                currNode = head;
            } else {
                ListNode newNode = new ListNode(resList.get(i));
                currNode.next = newNode;
                currNode = newNode;
            }
        }
        return head;
    }

    private static List<Integer> getNodeList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list;
    }
}
