package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 用栈来实现队列
 */
public class Test232 {


    /**
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     */


    //主要是用来压入
    private Stack<Integer> stack1;
    //主要是用来弹出
    private Stack<Integer> stack2;


    /**
     * Initialize your data structure here.
     */
    public Test232() {

        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();


    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {


        stack1.push(x);


    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return  stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        if(stack2.isEmpty()){

            while (!stack1.empty()){

                stack2.push(stack1.pop());
            }

        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return  stack1.empty() && stack2.empty();
    }
}
