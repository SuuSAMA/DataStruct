package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();

}
