package com.theia;

import org.junit.Test;

import java.util.Map;

/**
 * @author 17机制Theia
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    @Test
    public void test1(){
        MyMap<Integer, Character> linkedMap= new LinkedMap<>();
        for(int i = 0; i < 10; i++){
            linkedMap.add(i, (char)(i+70));
        }
        System.out.println(linkedMap);
        System.out.println(linkedMap.contains(4));
        System.out.println(linkedMap.getSize());
    }

    @Test
    public void test2(){
        MyMap<Integer, Character> bstMap= new BSTMap<>();
        int[] arr = new int[]{6, 2, 8, 0, 4, 7, 9};
        for(int i: arr){
            bstMap.add(i, (char)(i+70));
        }
        System.out.println(bstMap.get(2));
        System.out.println(arr);
    }

    @Test
    public void test3(){
        MyMap<Integer, Character> avlMap = new AVLMap<>();
        int[] arr = new int[]{1,2,4,5,3};
        for(int i: arr){
            avlMap.add(i, (char)(i+70));
        }
        System.out.println(avlMap.isEmpty());
        System.out.println(avlMap.remove(3));
        System.out.println(avlMap.remove(1));
        System.out.println(avlMap.contains(2));
    }

}
