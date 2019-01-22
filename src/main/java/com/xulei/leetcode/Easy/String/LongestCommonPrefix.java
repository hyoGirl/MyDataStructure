package com.xulei.leetcode.Easy.String;

/**
 * @author ashura1110
 * @ClassName LongestCommonPrefix
 * @description TODO
 * @Date 2019/1/22 23:48
 * @Version 1.0
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] arr={"flower","flow","flight"};
        String s = get(arr);
        System.out.println(s);
    }

    public static String get(String[] arr){

        if(arr.length==0){
            return "";
        }

        String prefix=arr[0];
        for (int i = 1; i < arr.length; i++) {

            while(arr[i].indexOf(prefix)!=0){
                    //sunString 包含前面不包含后面.意味着每次都少一个
                prefix=prefix.substring(0,prefix.length()-1);

                if(prefix==""){
                    return "";
                }

            }

        }
        return prefix;
    }


}
