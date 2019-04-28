package com.xulei.leetcode.Easy.Hash;

/**
 * 找不同
 */
public class T389Find_the_Difference {



    public char findTheDifference(String s, String t) {


        char[] chars = s.toCharArray();

        char[] chars1 = t.toCharArray();


        int sum1=0;
        int sum2=0;

        for (int i = 0; i < chars.length; i++) {
            sum1+=chars[i];
        }
        for (int j = 0; j < chars1.length; j++) {
            sum2+=chars1[j];
        }
        return  (char)(sum2 - sum1);

    }
}
