package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 比较含退格的字符串
 */
public class T844 {


    //给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。


//    输入：S = "ab#c", T = "ad#c"
//    输出：true
//    解释：S 和 T 都会变成 “ac”。

    /**
     * # 其实就是删除，使用栈，如果插入数据是#就删除，否则就添加，最后判断两个栈是不是相等就完事了
     */

    public static boolean backspaceCompare(String S, String T) {

        return backspace(S).equals(backspace(T));
    }


    public static Stack<Character> backspace(String S){

            Stack<Character> stack=new Stack<Character>();
            char[] chars = S.toCharArray();
            for(int i=0;i<S.length();i++){
                if(S.charAt(i)=='#'){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(S.charAt(i));
                }
            }
            return stack;
    }
}
