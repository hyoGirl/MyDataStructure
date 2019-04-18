package com.xulei.leetcode.medium.Stack;


import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class T150 {


//    说明：
//
//    整数除法只保留整数部分。有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
    // 逆波兰表达式：a+b ---> a,b,+


//    输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//    输出: 22
//    解释:
//            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//            = ((10 * (6 / (12 * -11))) + 17) + 5
//            = ((10 * (6 / -132)) + 17) + 5
//            = ((10 * 0) + 17) + 5
//            = (0 + 17) + 5
//            = 17 + 5
//            = 22


    /**
     * 逆波兰表达式，其实i就是后缀表达式，
     * <p>
     * 如果当前字符为变量或者为数字，则压栈，如果是运算符，则将栈顶两个元素弹出作相应运算，结果再入栈，最后当表达式扫描完后，栈里的就是结果。
     *
     * @param tokens
     * @return
     */

    public static int evalRPN(String[] tokens) {

        if (tokens.length == 0 || tokens == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }

        }
        return stack.pop();

    }


    public static void main(String[] args) {

        String[] ss = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(ss));


    }
}
