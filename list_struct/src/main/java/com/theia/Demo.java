package com.theia;

import org.junit.Test;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    /**
     * 链表实现测试
     */
    @Test
    public void test8(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for(int i = 0; i < 5; i++){
            myLinkedList.addFirst(i);
            System.out.println(myLinkedList);
        }
        myLinkedList.addLast(3);
        System.out.println(myLinkedList);
        myLinkedList.removeElement(3);
        System.out.println(myLinkedList);
    }

    /**
     * 链表队列实现测试
     */
    @Test
    public void test9(){
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i = 0; i < 9; i++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if(i % 3 == 2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
        System.out.println(linkedListQueue.getFront());
        System.out.println(linkedListQueue.isEmpty());
    }

    @Test
    public void test10(){
        RecursiveLinkerList<Integer> rll = new RecursiveLinkerList<>();
        for(int i = 0; i < 6; i++){
            rll.addFirst(i);
        }
        System.out.println(rll);
        rll.add(6, 9);
        System.out.println(rll);
    }
}
