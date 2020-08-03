package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class AVLMap<K extends Comparable, V> implements MyMap<K, V> {

    private class Node{
        public K key;
        public V value;
        public int height;
        public Node left;
        public Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public AVLMap(){
        root = null;
        size = 0;
    }

    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        size++;
    }

    private Node add(Node cur, K key, V value){
        if(cur == null){
            return new Node(key, value);
        }
        if(key.compareTo(cur.key) < 0){
            cur.left = add(cur.left, key, value);
        }
        else if(key.compareTo(cur.key) > 0){
            cur.right = add(cur.right, key, value);
        }
        return ensureBalance(cur);
    }

    private Node ensureBalance(Node node){
        if(node == null){
            return node;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }
        else if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        else if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        else if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node rightRotate(Node cur) {
        System.out.println("rightRotate");
        Node leftTree = cur.left;
        Node var1 = leftTree.right;
        cur.left = var1;
        leftTree.right = cur;
        if(var1 != null){
            var1.height = Math.max(getHeight(var1.left), getHeight(var1.right)) + 1;
        }
        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
        return leftTree;
    }

    private Node leftRotate(Node cur) {
        System.out.println("leftRotate");
        Node rightTree = cur.right;
        Node var1 = rightTree.left;
        cur.right = var1;
        rightTree.left = cur;
        if(var1 != null){
            var1.height = Math.max(getHeight(var1.left), getHeight(var1.right)) + 1;
        }
        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
        return rightTree;
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

    private Node remove(Node cur, K key){
        if(cur == null){
            return null;
        }
        Node resultNode;
        if(key.compareTo(cur.key) < 0){
            cur.left = remove(cur.left, key);
            resultNode = cur;
        }
        else if(key.compareTo(cur.key) > 0){
            cur.right = remove(cur.right, key);
            resultNode = cur;
        }
        else {
            if(cur.left == null){
                Node rightNode = cur.right;
                cur.right = null;
                size--;
                resultNode = rightNode;
            }
            else if(cur.right == null){
                Node leftNode = cur.left;
                cur.left = null;
                size--;
                resultNode = leftNode;;
            }
            else {
                Node node = minimum(cur.right);
                node.right = removeMin(cur.right);
                node.left = cur.left;
                cur.left = cur.right = null;
                resultNode = node;
            }
        }
        return ensureBalance(resultNode);
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
        return ensureBalance(cur);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node cur) {
        if(cur == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(cur);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(cur.left) && isBalanced(cur.right);
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node cur, K key){
        if(cur == null){
            return false;
        }
        if(key.compareTo(cur.key) < 0){
            return contains(cur.left, key);
        }
        else if(key.compareTo(cur.key) > 0){
            return contains(cur.right, key);
        }
        else {
            return true;
        }
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
}
