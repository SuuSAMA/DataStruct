package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyCircularQueue <E> implements Queue<E> {

    private int front;
    private int tail;
    private E[] elements;
    private int size;

    public MyCircularQueue(){
        this(10);
    }

    public MyCircularQueue(int capacity) {
        this.size = 0;
        this.front = 0;
        this.tail = 0;
        this.elements = (E[])new Object[++capacity];
    }

    @Override
    public void enqueue(E element){
        elements[tail] = element;
        if((tail+1) % elements.length == front){
            resize(getCapacity() * 2);
        }
        tail = (tail+1) % elements.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newElements = (E[]) new Object[++capacity];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[(front + i) % elements.length];
        }
        front = 0;
        tail = size;
        elements = newElements;
    }

    private int getCapacity(){
        return elements.length - 1;
    }

    @Override
    public E dequeue(){
        E value = getFront();
        elements[front] = null;
        front = (front+1) % elements.length;
        size--;
        if(size <= getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return value;
    }

    @Override
    public E getFront(){
        if(size == 0){
            throw new IllegalArgumentException("Circular queue is empty");
        }
        return elements[front];
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return tail == front;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "front=" + front + ", " +
                "tail=" + tail + ", " +
                "size=" + size + ", " +
                "capacity=" +getCapacity() +
                '}';
    }

}
