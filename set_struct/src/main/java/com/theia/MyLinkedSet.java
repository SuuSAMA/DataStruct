package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyLinkedSet<E> implements MySet<E> {

    private MyLinkedList myLinkedList;

    public MyLinkedSet(){
        myLinkedList = new MyLinkedList();
    }

    @Override
    public void add(E element) {
        if(!contains(element)){
            myLinkedList.addFirst(element);
        }
    }

    @Override
    public void remove(E element) {
        myLinkedList.removeElement(element);
    }

    @Override
    public boolean contains(E element) {
        return myLinkedList.contains(element);
    }

    @Override
    public int getSize() {
        return myLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }
}
