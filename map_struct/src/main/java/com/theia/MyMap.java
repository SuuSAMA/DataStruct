package com.theia;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public interface MyMap<K, V> {

    public void add(K key, V value);

    public V remove(K key);

    public boolean contains(K key);

    public V get(K key);

    public void set(K key, V value);

    public int getSize();

    public boolean isEmpty();

}
