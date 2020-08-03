package com.theia;

import org.junit.Test;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    /**
     * 数组队列实现测试
     */
    @Test
    public void test6(){
        MyQueue<Integer> myQueue = new MyQueue<>();
        for(int i = 0; i < 12; i++){
            myQueue.enqueue(i);
        }
        System.out.println(myQueue.toString());
        Integer value1 = myQueue.dequeue();
        System.out.println("value1 = " + value1);
        System.out.println(myQueue.toString());
        Integer value2 = myQueue.getFront();
        System.out.println("value2 = " + value2);
        System.out.println(myQueue.toString());
        System.out.println(myQueue.isEmpty());
    }

    /**
     * 循环队列实现测试
     */
    @Test
    public void test7(){
        MyCircularQueue<Integer> myCircularQueue = new MyCircularQueue<>();
        for(int i = 0; i < 15; i++){
            myCircularQueue.enqueue(i);
        }
        System.out.println(myCircularQueue.toString());
        Integer value1 = myCircularQueue.dequeue();
        System.out.println("value1 = " + value1);
        System.out.println(myCircularQueue.toString());
        Integer value2 = myCircularQueue.getFront();
        System.out.println("value2 = " + value2);
        System.out.println(myCircularQueue.toString());
        System.out.println(myCircularQueue.isEmpty());
    }
}
