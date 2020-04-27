package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * author:徐磊
 * Date:2020/4/8
 * Time:14:47
 * Description:
 */
public class MinStack2 {

//    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
//    调用 min、push 及 pop 的时间复杂度都是 O(1)。


    /**
     *
     *
     *
     *
     *
     */

    private Stack<Integer> minStack;
    int min=Integer.MAX_VALUE;


    public MinStack2() {
        minStack=new Stack<>();
        min=0;

    }

    public void push(int x) {
        minStack.push(x);
        if(min>=x){
            min=x;
        }
    }
    public void pop() {
        minStack.pop();

    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
