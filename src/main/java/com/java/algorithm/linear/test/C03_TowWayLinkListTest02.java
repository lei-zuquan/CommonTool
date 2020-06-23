package com.java.algorithm.linear.test;

import com.java.algorithm.linear.TowWayLinkList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:05 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_TowWayLinkListTest02 {
    public static void main(String[] args) {
        TowWayLinkList<Integer> list = new TowWayLinkList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        for (Integer i : list) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("--------------------");
        list.reverse();
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
