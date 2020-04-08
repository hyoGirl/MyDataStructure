package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * author:徐磊
 * Date:2020/4/8
 * Time:10:25
 * Description:
 */
public class CQueue {

//    用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
//    分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    /**
     *
     * 两个栈，一个是用来从尾部压入数据，一个是从头部删除数据
     *
     * 1：压入数据的时候，栈1 负责放入数据
     * 2：从头部删除数据的时候，从栈2中取，如果栈2没有数据，就先把数据全部压入，
     * 如果栈2有数据，此时栈2的数据头部就是第一个数据。
     * 如果栈2的数据都被获取完毕了，就再去看看栈1的数据，看栈1是否有数据，有数据就压入栈2，
     * 然后栈2再取数据，
     * 如果栈1 栈2 都米有数据了，就是-1
     *
     */

    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public CQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            return -1;
        }
    }


}
