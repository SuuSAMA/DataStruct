package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class BSTMap<K extends Comparable, V> implements MyMap<K, V> {

    private class Node{

        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "("+key.toString() + ":" + value.toString()+")";
        }

    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node cur, K key, V value){
        if(cur == null){
            size++;
            return new Node(key, value);
        }
        if(cur.key.compareTo(key) > 0){
            cur.left = add(cur.left, key, value);
        }else if(cur.key.compareTo(key) < 0){
            cur.right = add(cur.right, key, value);
        }else {
            cur.value = value;
        }
        return cur;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
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

    private Node getNode(Node cur, K key){
        if(cur == null){
            return null;
        }
        if(cur.key.compareTo(key) > 0){
            return getNode(cur.left, key);
        }else if(cur.key.compareTo(key) < 0){
            return getNode(cur.right, key);
        }else {
            return cur;
        }
    }

    private Node minimum(Node cur){
        if(cur.left == null){
            return cur;
        }
        return minimum(cur.left);
    }

    private Node removeMin(Node cur){
        if(cur.left == null){
            Node rightNode = cur.right;
            cur.right = null;
            size--;
            return rightNode;
        }
        cur.left = removeMin(cur.left);
        return cur;
    }

    private Node remove(Node cur, K key){
        if(cur == null){
            return null;
        }
        if(cur.key.compareTo(key) > 0){
            cur.left = remove(cur.left, key);
            return cur;
        }else if(cur.key.compareTo(key) < 0){
            cur.right = remove(cur.right, key);
            return cur;
        }else {
            if(cur.left == null){
                Node rightNode = cur.right;
                cur.right = null;
                size--;
                return rightNode;
            }else if(cur.right == null){
                Node leftNode = cur.left;
                cur.left = null;
                size--;
                return leftNode;
            }
            Node newRoot = minimum(cur.right);
            newRoot.right = removeMin(cur.right);
            newRoot.left = cur.left;
            cur.left = cur.right = null;
            return newRoot;
        }
    }

}
