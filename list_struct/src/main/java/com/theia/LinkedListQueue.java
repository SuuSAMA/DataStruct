package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{

        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E element) {
        if(size == 0){
            tail = new Node(element);
            head = tail;
        }else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Dequeue fail, queue is empty!");
        }
        Node resNote = head;
        head = head.next;
        resNote.next = null;
        if(head == null) {
            tail = null;
        }
        size--;
        return resNote.element;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Dequeue fail, queue is empty!");
        }
        return head.element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyLinkedList{value={");
        Node cur = head;
        while (cur != null){
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        stringBuilder.append("}, size=" + size + "}");
        return stringBuilder.toString();
    }

}
