package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * author:徐磊
 * Date:2020/4/7
 * Time:16:16
 * Description:
 */
public class MinStack {


//    请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/min-stack-lcci
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    /**
     * 重点在这里，如果第一个栈没有值，那么第二个栈也不会存在的，因为第一个栈的数据会永远多余第二个栈。
     *
     * 这个和模拟队列不一样
     */
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer top = stack.pop();
        if (!minStack.isEmpty() && top.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? 0 : minStack.peek();
    }
}



