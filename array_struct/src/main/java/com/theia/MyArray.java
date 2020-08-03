package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyArray<E> {

    private int size = 0;
    private E[] element;

    public MyArray(int capacity) {
        element = (E[])new Object[capacity];
        this.size = 0;
    }

    public MyArray(){
        this(10);
    }

    public void add(E value){
        add(size, value);
    }

    public void add(int key, E value){
        if(key < 0 || key > size){
            throw new IllegalArgumentException("Index exceeds limit length");
        }
        if(size >= element.length){
            resize(2 * element.length);
        }
        E o = null;
        for(int index = key; index < size; index++){
            o = element[index];
            element[index] = value;
            value = o;
        }
        element[size] = value;
        size++;
    }

    public void set(int key, E value){
        if(key < 0 || key > size){
            throw new IllegalArgumentException("Index exceeds limit length");
        }else {
            element[key] = value;
        }
    }

    public void remove(int key){
        if(key < 0 || key > size - 1){
            throw new IllegalArgumentException("Index exceeds array length");
        }
        Object value = null;
        for(int index = key; index < size; index++){
            element[index - 1] = element[index];
        }
        size--;
        if(size == element.length / 4 && element.length / 2 != 0){
            resize((element.length) / 2);
        }
    }

    private void resize(int capacity){
        E[] newElement = (E[])new Object[capacity];
        for(int index = 0; index < size; index++){
            newElement[index] = element[index];
        }
        element = newElement;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public E get(int key){
        return element[key];
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "size=" + size + ", " +
                "capacity=" + element.length +
                '}';
    }
}
