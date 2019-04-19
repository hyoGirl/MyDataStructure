package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 检查替换后的词是否有效
 */
public class T1003 {


//    对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
//
//    例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
//
//    如果给定字符串 S 有效，则返回 true；否则，返回 false。


//    输入："aabcbc"
//    输出：true
//    解释：
//    从有效字符串 "abc" 开始。
//    然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。


    /**
     *
     * 思路：只有满足了abc才是正确的，
     *
     * 我们首先建立一个栈，遍历输入的字符，如果当时输入的字符是C 我们就判断栈顶元素是不是ab
     *
     * 如果是。我们就把 ba 弹出，这样我们就构建成了abc 一个正确的
     *
     * 如果栈顶元素不是ab  那么就返回false。因为无法组成abc这样的数据
     *
     * 如果当时输入的字符不是C .那就直接压入栈中
     *
     * 最后判断栈是不是空，不是，就返回false，是就返回true
     *
     */

    public boolean isValid(String S) {
        Stack<Character> stack=new Stack<>();
        char[] chars = S.toCharArray();
        for(char ch:chars){
            if(ch == 'c'){
                if(stack.isEmpty() || stack.pop()!='b'){
                    return false;
                }
                if(stack.isEmpty() || stack.pop()!='a'){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    //错误案例：  "abccba"
    public boolean isValid2(String S) {
        Stack<Character> stack=new Stack<>();
        char[] chars = S.toCharArray();
        for(char ch:chars){
            if(ch == 'c'){
                if(!stack.isEmpty()&&  stack.pop()=='b'  && !stack.isEmpty()&&  stack.pop()=='a'){

                    //此时的return 就会返回true  停止了程序不再运行，但是后面还是有数据加入
                    //所以只能从反面来判断
                    return true;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 3; j++) {

                if(j==1){
                    System.out.println("j: "+j);
                    return;
                }
                System.out.println("i: "+i);
            }


        }



    }

}
