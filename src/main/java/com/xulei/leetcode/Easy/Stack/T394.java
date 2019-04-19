package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 字符串解码
 */
public class T394 {


//    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//    s = "3[a]2[bc]", 返回 "aaabcbc".
//    s = "3[a2[c]]", 返回 "accaccacc".
//    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".


    //思路：如果遇到 ']'，就一直在栈中找到 '['，将之间的字符连接起来，
    // 将 '['前面的数字连接起来作为出现次数再次压栈，遇到数字、字母、'['就直接压栈，最后将栈里的字符串弹出连接起来就ok了


    // 每次结果都是弹出栈后相加，不要直接+=

    public static String decodeString(String s) {


        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch == ']') {
                String str = "";
                while (!stack.peek().equals("[")) {
                    str = stack.pop()+str;
                }
                stack.pop();//[
                String count = "";
                while (!stack.isEmpty() && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    count = stack.pop()+count;
                }
                int counts = Integer.valueOf(count);
                String data = "";
                for (int j = 0; j < counts; j++) {
                    data = str+data;
                }
                stack.push(data);
            } else {
                //如果是数字，字母 以及【 就直接入栈
                String data = "" + s.charAt(i);
                stack.push(data);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            //这里不能写成： res+=stack.pop();这个地方就变成了 res=res+stack.pop();
            // 如果栈里面是 ab  先把b弹出 再弹出a 结果就是ba  但是实际上却需要的是 ab
            res = stack.pop()+res;
        }
        return res;
    }


    public static String d2(String s) {

        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String string = "";
                while (!stack.peek().equals("[")) {
                    string = stack.pop() + string;
                }
                stack.pop();

                String countString = "";
                while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString = stack.pop() + countString;
                }
                int count = Integer.parseInt(countString);

                String retString = "";
                for (int j = 0; j < count; j++) {
                    retString = retString + string;
                }
                stack.push(retString);
            } else {
                String str = "" + s.charAt(i);
                stack.push(str);
            }
        }

        String aaa = "";
        while (!stack.isEmpty()) {
            aaa = stack.pop() + aaa;
        }
        return aaa;

    }

    public static void main(String[] args) {

        String data = "3[a]2[bc]";


        System.out.println(d2(data));

//        System.out.println(decodeString(data));


    }
}
