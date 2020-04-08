package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * author:徐磊
 * Date:2020/4/7
 * Time:16:39
 * Description:
 */
public class StackToQueue {

//    实现一个MyQueue类，该类用两个栈来实现一个队列。

    Stack<Integer> writeStack;
    Stack<Integer> readStack;

    public StackToQueue() {
        writeStack=new Stack<>();
        readStack=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        writeStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return readStack.pop();
    }

    /** Get the front element. */
    public int peek() {
       if(!readStack.isEmpty()){
           return  readStack.peek();
       }
       while(!writeStack.isEmpty()){
           readStack.push(writeStack.pop());
       }
       return readStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return writeStack.isEmpty() && readStack.isEmpty();
    }
}
