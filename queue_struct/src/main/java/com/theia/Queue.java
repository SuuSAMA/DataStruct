package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public interface Queue<E> {

    void enqueue(E element);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();

}
