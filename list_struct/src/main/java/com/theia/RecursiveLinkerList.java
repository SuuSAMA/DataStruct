package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class RecursiveLinkerList<E> {

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

    private int size;
    private Node dummyHead;

    public RecursiveLinkerList(){
        int size = 0;
        dummyHead = new Node();
    }

    public void addFirst(E element){
        add(0, element);
    }

    public void add(int index, E element){
        add(index, dummyHead, element);
        size++;
    }

    private void add(int index, Node cur, E element){
        if(index > 0){
            add(index - 1, cur.next, element);
        }else {
            dummyHead.next = new Node(element, cur.next);
        }
        if(cur.element != null){
            dummyHead.next = new Node(cur.element, dummyHead.next);
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
