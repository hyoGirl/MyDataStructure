package com.xulei.leetcode.Easy.String;

import java.util.Arrays;

/**
 * 翻转字符串
 */
public class T344 {


    public static void reverseString(char[] s) {

        int i=0;
        int j=s.length-1;

        while(i<=j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {

        char[] arr={'h','e','l','l','o'};

        reverseString(arr);


        System.out.println(Arrays.toString(arr));


    }
}
