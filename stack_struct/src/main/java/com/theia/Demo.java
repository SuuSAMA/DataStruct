package com.theia;

import org.junit.Test;

/**
 * @author 17机制Suu
 * @copyright 神农大学生软件创新中心版权所有 @2020
 */
public class Demo {

    /**
     * 栈的实现测试
     */
    @Test
    public void test2() {
        MyStack<Car> myStack = new MyStack<>();
        System.out.println(myStack.isEmpty());
        Car car1 = new Car("Audi A8L", 80.6f);
        Car car4 = new Car("Audi A8", 56.4f);
        for(int i = 0; i < 11; i++){
            myStack.push(car1);
        }
        myStack.push(car4);
        System.out.println(myStack);
        Car car3 = myStack.pop();
        System.out.println(car3);
        System.out.println(myStack);

        Car car2 = myStack.peek();
        System.out.println(car2);

        int size = myStack.getSize();
        System.out.println(size);

        System.out.println(myStack.isEmpty());
    }

    /**
     * 是否为封闭括号测试
     */
    @Test
    public void test3(){
        System.out.println(isValid("}"));
    }

    public boolean isValid(String s) {
        MyStack<Character>stack = new MyStack<Character>();
        for(char c: s.toCharArray()){
            if(c=='('){stack.push(')');}
                else if(c=='['){stack.push(']');}
                else if(c=='{'){stack.push('}');}
                else if(stack.isEmpty()||c!=stack.pop()){return false;}
        }
        return stack.isEmpty();
    }

    @Test
    public void test4(){
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        int value1 = sortedStack.peek();
        System.out.println(value1);
        sortedStack.pop();
        int value2 = sortedStack.peek();
        System.out.println(value2);
    }

    @Test
    public void test5(){
        MyStackQueue queue = new MyStackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int value1 = queue.peek();
        System.out.println(value1);
        int value2 = queue.pop();
        System.out.println(value2);
        boolean b = queue.empty();
        System.out.println(b);
    }


}
