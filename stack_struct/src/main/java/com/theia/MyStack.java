package com.theia;


/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyStack<E> implements Stack<E>{

    private int size;
    private E[] element;

    public MyStack(){
        this(10);
    }

    public MyStack(int capacity) {
        this.size = 0;
        this.element = (E[])new Object[capacity];
    }

    @Override
    public void push(E value){
        if(size == element.length){
            resize(2 * element.length);
        }
        element[size] = value;
        size++;
    }

    private void resize(int capacity) {
        E[] newElement = (E[])new Object[capacity];
        for(int index = 0; index < size; index++){
            newElement[index] = element[index];
        }
        element = newElement;
    }

    @Override
    public E pop(){
        E result = peek();
        size--;
        if(size == element.length / 4 && element.length / 2 != 0){
            resize(element.length / 2);
        }
        return result;
    }

    @Override
    public E peek(){
        if(size == 0){
            throw new IllegalArgumentException("Peek fail, stack no element!");
        }
        return element[size - 1];
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
        return "MyStack{" +
                "size=" + size + ", " +
                "capacity=" + element.length +
                '}';
    }
}
