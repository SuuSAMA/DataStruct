package com.theia;

import org.junit.Test;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    @Test
    public void test1(){
        BST<Integer> bst = new BST<>();
        int[] arr = {5,2,7,6,4,0,9};
        for(int i: arr){
            bst.add(i);
        }
        bst.prevOrder();
        bst.inOrder();
        bst.afterOrder();
        System.out.println(bst.contains(9));
    }

    @Test
    public void test2(){
        BST<Integer> bst = new BST<>();
        int[] arr = {5,2,7,6,4,0,9};
        for(int i: arr){
            bst.add(i);
        }
        bst.levelOrder();
        System.out.println(bst.contains(4));
    }

    @Test
    public void test3(){
        BST<Integer> bst = new BST<>();
        int[] arr = {5,2,7,6,4,0,9};
        for(int i: arr){
            bst.add(i);
        }
        bst.prevOrder();
        System.out.println("===========");
        bst.remove(2);
        bst.prevOrder();
    }

    @Test
    public void test4(){
        AVLTree<Integer> avlTree = new AVLTree<>();
        int[] arr = {4,0,6,-1,7,8,9,2,3,1};
//        int[] arr = {1,2,3};
//        int[] arr = {1,3,2};
        for(int i: arr){
            avlTree.add(i);
        }
        System.out.println(avlTree.isBalanced());
        avlTree.remove(4);
        System.out.println(avlTree.isBalanced());
    }

    @Test
    public void test5(){
        RedBlackTree<Integer, Integer> redBlackTree = new RedBlackTree<>();
//        int[] arr = {4,0,6,-1,7,8,9,2,3,1};
        int[] arr = {62,14,22,8,9,77,64,43,21};
        for(int i: arr){
            redBlackTree.add(i, null);
        }
        System.out.println();
    }

}
