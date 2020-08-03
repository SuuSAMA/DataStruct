package com.theia;

import java.util.LinkedList;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class LinkedMap<K, V> implements MyMap<K, V>{

    private class Node{

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "("+key.toString() + ":" + value.toString()+")";
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
        }else {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        V value = null;
        while (cur.next != null){
            if(cur.next.key.equals(key)){
                value = cur.next.value;
                cur.next = cur.next.next;
                size--;
            }else {
                cur = cur.next;
            }
        }
        return value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("This key is unused");

        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedMap{element = {");
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
