package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public interface MyTree<E> {

    public void add(E element);

    public boolean contains(E element);

    public boolean isEmpty();

    public int getSize();

    public void remove(E element);
}
