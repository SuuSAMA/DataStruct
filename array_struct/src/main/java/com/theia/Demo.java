package com.theia;

import org.junit.Test;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    /**
     * 集合实现测试
     */
    @Test
    public void test1(){
        MyArray<Personal> myList = new MyArray<>();
        Personal personal1 = new Personal("zhangsan",18 );
        Personal personal2 = new Personal("lisi", 22);
        for(int i = 0; i < 7; i++){
            myList.add(personal1);
        }
        myList.add(personal2);
        for(int i = 0; i < 6; i++){
            myList.remove(2);
        }
        System.out.println(myList);
    }
}
