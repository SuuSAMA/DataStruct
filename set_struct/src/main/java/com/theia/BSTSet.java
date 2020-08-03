package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class BSTSet<E extends Comparable<E>> implements MySet<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E element) {
        bst.add(element);
    }

    @Override
    public void remove(E element) {
        bst.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return bst.contains(element);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
