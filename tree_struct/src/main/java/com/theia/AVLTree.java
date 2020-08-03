package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class AVLTree<E extends Comparable> implements MyTree<E> {

    private class Node{
        public E element;
        public int height;
        public Node left;
        public Node right;

        public Node(E element){
            this.element = element;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
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
    public void add(E element){
        root = add(root, element);
        size++;
    }

    private Node add(Node cur, E element){
        if(cur == null){
            return new Node(element);
        }
        if(element.compareTo(cur.element) < 0){
            cur.left = add(cur.left, element);
        }
        else if(element.compareTo(cur.element) > 0){
            cur.right = add(cur.right, element);
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
    public boolean contains(E element){
        return contains(root, element);
    }

    private boolean contains(Node cur, E element){
        if(cur == null){
            return false;
        }
        if(element.compareTo(cur.element) < 0){
            return contains(cur.left, element);
        }
        else if(element.compareTo(cur.element) > 0){
            return contains(cur.right, element);
        }
        else {
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void remove(E element){
        root = remove(root, element);
    }

    private Node remove(Node cur, E element){
        if(cur == null){
            return null;
        }
        Node resultNode;
        if(element.compareTo(cur.element) < 0){
            cur.left = remove(cur.left, element);
            resultNode = cur;
        }
        else if(element.compareTo(cur.element) > 0){
            cur.right = remove(cur.right, element);
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

}
