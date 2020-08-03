package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class AVLSet<E extends Comparable> implements MySet<E> {

    private AVLTree<E> avlTree;

    public AVLSet(){
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E element) {
        avlTree.add(element);
    }

    @Override
    public void remove(E element) {
        avlTree.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return avlTree.contains(element);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
