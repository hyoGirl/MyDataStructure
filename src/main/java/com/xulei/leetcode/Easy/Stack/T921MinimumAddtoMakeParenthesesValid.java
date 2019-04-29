package com.xulei.leetcode.Easy.Stack;

/**
 * 921. 使括号有效的最少添加
 */
public class T921MinimumAddtoMakeParenthesesValid {


//    给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
//
//    从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
//
//    它是一个空字符串，或者
//    它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
//    它可以被写作 (A)，其中 A 是有效字符串。
//    给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。


//    输入："())"
//    输出：1


//    输入："((("
//    输出：3


    public int minAddToMakeValid(String S) {
        int res = 0, record = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                record++;
            } else {
                //如果是右边的括号出现了，就把左边括号数量删除一个。直到左边括号数量为0
                if (record != 0) {
                    record--;
                } else {
                    //当左边括号为0的时候，表示已经对齐了，现在多一个右边的，就+1。表示多出来的
                    res++;
                }
            }
        }
        //这里为啥不直接返回res尼？有一种情况，就是全部都是左边的了。此时res=0；实际上返回的数据就是左边的数量，因为res=0.所以加上去也没关系。
        //还有一种情形，全部都是右边的，那么就是record有数据，但是res=0
        return res + record;
    }

}
