package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class MyLinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E element){
        add(0, element);
    }

    public boolean contains(E element){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.element.equals(element)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index exceeds linker list size");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        prev.next = new Node(element, prev.next);
        size++;
    }

    public void addLast(E element){
        add(size, element);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index exceeds linker list size");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.element;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E element){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index exceeds linker list size");
        }
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.element = element;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index exceeds linker list size");
        }
        Node perv = dummyHead;
        for(int i = 0; i < index; i++){
            perv = perv.next;
        }
        Node delNode = perv.next;
        perv.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.element;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E element){
        Node cur = dummyHead;
        while (cur.next != null){
            if(cur.next.element.equals(element)){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyLinkedList{value={");
        Node cur = dummyHead.next;
        while (cur != null){
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        stringBuilder.append("}, size=" + size + "}");
        return stringBuilder.toString();
    }

}
