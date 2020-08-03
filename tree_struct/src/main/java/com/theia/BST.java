package com.theia;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class BST <E extends Comparable<E>> implements MyTree<E> {

    private class Node{
        public E element;
        public Node left;
        public Node right;

        public Node(E element){
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
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
        }else if(element.compareTo(cur.element) > 0){
            cur.right = add(cur.right, element);
        }
        return cur;
    }

    private E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).element;
    }

    private Node maximum(Node cur){
        if(cur.right == null){
            return cur;
        }
        return maximum(cur.right);
    }

    private E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).element;
    }


    private Node minimum(Node cur){
        if(cur.left == null){
            return cur;
        }
        return minimum(cur.left);
    }

    private E removeMax(){
        E max = maximum();
        root = removeMax(root);
        return max;
    }

    private E removeMin(){
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    private Node removeMax(Node cur){
        if(cur.right == null){
            Node node = cur.left;
            cur.left = null;
            size--;
            return node;
        }
        cur.right = removeMax(cur.right);
        return cur;
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

    @Override
    public void remove(E value){
       root = remove(root, value);
    }

    private Node remove(Node cur, E value){
        if(cur == null){
            return null;
        }
        if(value.compareTo(cur.element) < 0){
            cur.left = remove(cur.left, value);
            return cur;
        }else if(value.compareTo(cur.element) > 0){
            cur.right = remove(cur.right, value);
            return cur;
        }else {
            if(cur.left == null){
                Node rightNode = cur.right;
                cur.right = null;
                size--;
                return rightNode;
            }
            if(cur.right == null){
                Node leftNode = cur.left;
                cur.left = null;
                size--;
                return leftNode;
            }
            Node node = minimum(cur.right);
            node.right = removeMin(cur.right);
            node.left = cur.left;
            cur.left = cur.right = null;
            return node;
        }
    }

    @Override
    public boolean contains(E value){
        return contains(root, value);
    }

    private boolean contains(Node cur, E value){
        if(cur == null){
            return false;
        }
        if(value.compareTo(cur.element) < 0){
            return contains(cur.left, value);
        }else if(value.compareTo(cur.element) > 0){
            return contains(cur.right, value);
        }else {
            return true;
        }
    }

    public void prevOrder(){
        prevOrder(root);
    }

    private void prevOrder(Node cur){
        if(cur == null){
            return;
        }

        System.out.println("prev: " + cur.element);
        prevOrder(cur.left);
        prevOrder(cur.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node cur){
        if(cur == null){
            return;
        }

        inOrder(cur.left);
        System.out.println("mid: " + cur.element);
        inOrder(cur.right);
    }

    public void afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node cur){
        if(cur == null){
            return;
        }

        afterOrder(cur.left);
        afterOrder(cur.right);
        System.out.println("after: " + cur.element);
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node cur){
        Queue<Node> queue = new MyCircularQueue<>();
        Node node = cur;
        for(int index = 0; index < size; index++){
            if(index > 0){
                node = queue.dequeue();
            }
            System.out.println(node.element);
            if(node.left != null){
                queue.enqueue(node.left);
            }
            if(node.right != null){
                queue.enqueue(node.right);
            }
        }
    }

}
