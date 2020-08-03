package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public interface MySet<E> {

    public void add(E element);

    public void remove(E element);

    public boolean contains(E element);

    public int getSize();

    public boolean isEmpty();

}
