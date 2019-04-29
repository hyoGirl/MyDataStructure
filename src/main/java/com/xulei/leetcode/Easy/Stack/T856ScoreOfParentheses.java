package com.xulei.leetcode.Easy.Stack;

/**
 * @author ashura1110
 * @ClassName T856ScoreOfParentheses
 * @description TODO
 * @Date 2019/4/29 20:21
 * @Version 1.0
 */
public class T856ScoreOfParentheses {


//    给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//    () 得 1 分。
//    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
//    (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//    输入： "(()(()))"
//    输出： 6
//
//    输入： "()()"
//    输出： 2
//
//    输入： "()"
//    输出： 1


    public static int scoreOfParentheses(String S) {

        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
//                        左移运算符，num << 1,相当于num乘以2
//                        >>      :     右移运算符，num >> 1,相当于num除以2
                    ans += 1 << bal;
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        String data="()";
        System.out.println(scoreOfParentheses(data));


    }

}
