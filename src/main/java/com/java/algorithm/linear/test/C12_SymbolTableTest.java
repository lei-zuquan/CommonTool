package com.java.algorithm.linear.test;

import com.java.algorithm.linear.SymbolTable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:31 上午 2020/6/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C12_SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1, "张三");
        st.put(3, "李四");
        st.put(5, "王五");
        System.out.println(st.size());
        st.put(1,"老三");

        System.out.println(st.get(1));
        System.out.println(st.size());
        st.delete(1);
        System.out.println(st.size());
    }
}
