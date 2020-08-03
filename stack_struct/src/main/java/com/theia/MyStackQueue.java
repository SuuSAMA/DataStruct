package com.theia;

import java.util.Stack;

class MyStackQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyStackQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackOut.isEmpty()){
            stackIn.push(stackOut.pop());
        }
        stackIn.push(x);
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOut.size() == 0;
    }
}