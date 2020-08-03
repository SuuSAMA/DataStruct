package com.theia;

import java.util.HashMap;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public boolean color;
        public Node left;
        public Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.color = RED;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree(){
        root = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    private boolean isRed(Node node){
        if(node == null){
            return false;
        }
        return node.color;
    }

    private void changeColor(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node add(Node cur, K key, V value){
        if(cur == null){
            size++;
            return new Node(key, value);
        }

        if(key.compareTo(cur.key) < 0){
            cur.left = add(cur.left, key, value);
        }else if(key.compareTo(cur.key) > 0){
            cur.right = add(cur.right, key, value);
        }

        if(isRed(cur.right) && !isRed(cur.left)){
            cur = leftRotate(cur);
        }
        if(isRed(cur.left) && isRed(cur.left.left)){
            cur = rightRotate(cur);
        }
        if(isRed(cur.left) && isRed(cur.right)){
            changeColor(cur);
        }
        return cur;
    }

    private Node leftRotate(Node cur) {
        System.out.println("leftRotate");
        Node rightTree = cur.right;
        cur.right = rightTree.left;
        rightTree.left = cur;
        rightTree.color = cur.color;
        cur.color = RED;
        return rightTree;
    }

    private Node rightRotate(Node cur) {
        System.out.println("rightRotate");
        Node leftTree = cur.left;
        cur.left = leftTree.right;
        leftTree.right = cur;
        leftTree.color = cur.color;
        cur.color = RED;
        return leftTree;
    }

    private Node minimum(Node cur){
        if(cur.left == null){
            return cur;
        }
        return minimum(cur.left);
    }

    private Node removeMin(Node cur){
        if(cur.left == null){
            Node node = cur.right;
            cur.right = null;
            size--;
            return node;
        }
        cur.left = removeMin(cur.left);
        return cur;
    }

    public boolean contains(K key){
        return contains(root, key);
    }

    private boolean contains(Node cur, K key){
        if(cur == null){
            return false;
        }
        if(key.compareTo(cur.key) < 0){
            return contains(cur.left, key);
        }else if(key.compareTo(cur.key) > 0){
            return contains(cur.right, key);
        }else {
            return true;
        }
    }

}
