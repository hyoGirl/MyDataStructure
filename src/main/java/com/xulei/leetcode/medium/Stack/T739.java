package com.xulei.leetcode.medium.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/14 22:13
 * @Version 1.0
 */
public class T739 {

    public static void main(String[] args) {

//        int[] res={74, 73, 75, 71, 69, 72, 76, 73};
        int[] res={73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(res);
        System.out.println(Arrays.toString(ints));
    }

    //找出数组中大于当前元素的第一个元素，到当前元素的距离
//递减栈，当前元素与栈中元素比较，小则入栈，大则出栈并将二者之间的下标差值为出栈元素的结果值，并继续比较下一个栈顶元素
//如果栈为空，直接入栈(表示前面元素都找到了比自己大的值)

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        // 初始化所有的元素为0
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                System.out.println(temp);
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
}
