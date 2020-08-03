package com.theia;


/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyQueue <E> implements Queue<E> {

    private int size;
    private E[] elements;

    public MyQueue(){
        this(10);
    }

    public MyQueue(int capacity) {
        this.size = 0;
        this.elements = (E[])new Object[capacity];
    }

    @Override
    public void enqueue(E element){
        if(size == elements.length){
            resize(2 * elements.length);
        }
        elements[size] = element;
        size++;
    }

    private void resize(int capacity) {
        E[] newElements = (E[])new Object[capacity];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public E dequeue(){
        E[] temporaryQueue = (E[])new Object[elements.length];
        size--;
        for (int i = 0; i < size; i++){
            temporaryQueue[i] = elements[i+1];
        }
        E value = getFront();
        elements = temporaryQueue;
        if(size <= elements.length / 4 && elements.length / 2 != 0){
            resize(elements.length / 2);
        }
        return value;
    }

    @Override
    public E getFront(){
        return elements[0];
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "size=" + size + ", " +
                "capacity=" +elements.length +
                '}';
    }
}
