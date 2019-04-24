package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 删除最外层的括号
 */
public class T1021Remove_Outermost_Parentheses {


//    如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
//
//    给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
//
//    对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
//
//
//    输入："(()())(())"
//    输出："()()()"
//    解释：
//    输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//    删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
//
//
//    输入："()()"
//    输出：""
//    解释：
//    输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//    删除每个部分中的最外层括号后得到 "" + "" = ""。

    public static String removeOuterParentheses(String S) {


        /**
         * 思路
         * 1：首先是用到栈
         * ( ( ) ( ) ) ( ( ) )
         * 我们遍历到的元素是c，如果c!=')'，我们将c压入栈中
         * s: (
         * 然后发现遍历到的元素c依旧不是)，我们依旧将c压入栈中，并且此时我们发现栈的长度大于1，说明栈中有大于一个(，那么我们需要将此时的c添加到结果中。
         * ( ( ) ( ) ) ( ( ) )
         s: ((
         res: (
         *
         * 当我们继续遍历的时候，我们发现遍历到的c是)，我们判断出此时栈的长度大于1，说明栈中有大于一个(。
         * 我们将c添加到res中，并且我们知道此时的c和栈顶必然匹配成功，所以我们需要将栈顶元素弹出。
         *   ( ( ) ( ) ) ( ( ) )
         ↑
         s: (
         res: ()
         * 假如是 ((())) 这个题目不满足
         */

        //用计数器表示栈内左侧括号的数量

        int left = 0;
        String ans = "";

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            //思路就是，第一个左括号(  不会添加到结果中，此时left=0，不满足
            // 如果存在还是(  同时left>0  此时就是说明有多个(.结果中保存一个
            if (ch == '(' && left++ > 0) {
                ans += ch;
            }
            // 如果是)  此时栈内必须有多个(  如果只有一个(  那（）出栈后，就没有
            if (ch == ')' && --left > 0) {
                ans += ch;
            }
        }
        return ans;

    }

    public static String removeOuterParentheses2(String S) {


        String data = "";
        Stack<Character> stack = new Stack();
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(ch);
                if (stack.size() > 1) {
                    data += ch;
                }
            }
            if (ch == ')') {
                if (stack.peek() == '(') {
                    if (stack.size() > 1) {
                        data += ch;
                    }
                    stack.pop();

                }
            }

        }

        return data;

    }


    public static void main(String[] args) {

        String ss = "(()())(())";

        System.out.println(removeOuterParentheses(ss));
        System.out.println(removeOuterParentheses2(ss));

    }


}
