package com.theia;

class SortedStack {

    private int size;
    private int[] elements;

    public SortedStack() {
        this.size = 0;
        this.elements = new int[20];
    }

    public void push(int val) {
        int num = 0;
        if(size == elements.length){
            resize(elements.length * 2);
        }
        for (int i = 0; i < size; i++){
            if(val > elements[i]){
                num = elements[i];
                elements[i] = val;
                val = num;
            }
        }
        elements[size++] = val;
    }

    public void pop() {
        if(size != 0){
            elements[size-1] = elements[--size];
        }
    }

    public int peek() {
        if(size != 0){
            return elements[size-1];
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity){
        int[] newElement = new int[capacity];
        for(int i = 0; i < size; i++){
            newElement[i] = elements[i];
        }
        elements = newElement;
    }

}