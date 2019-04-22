package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * @author ashura1110
 * @ClassName T856_Score_of_Parentheses
 * @description TODO
 * @Date 2019/4/22 20:30
 * @Version 1.0
 */
public class T856_Score_of_Parentheses {


//    给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
//
//            () 得 1 分。
//    AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
//            (A) 得 2 * A 分，其中 A 是平衡括号字符串。
//
//
//    输入： "(()(()))"
//    输出： 6
//
//    输入： "()()"
//    输出： 2


    public static int scoreOfParentheses(String S) {


        Stack<Character>  stack=new Stack<>();

        char[] chars = S.toCharArray();

        int score=0;

        for (int i = 0; i < chars.length ; i++) {

           char ch= chars[i];

           if(ch==')'){

               while(!stack.isEmpty() && stack.peek()=='('){
                   stack.pop();
                   score+=1;
               }

           }else{
               stack.push(ch);
           }



        }
        
        


    }

}
