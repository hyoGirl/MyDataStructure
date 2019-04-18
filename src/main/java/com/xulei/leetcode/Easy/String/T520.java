package com.xulei.leetcode.Easy.String;

/**
 * 检测大写字母
 */
public class T520 {


//    给定一个单词，你需要判断单词的大写使用是否正确。
//
//    我们定义，在以下情况时，单词的大写用法是正确的：
//
//    全部字母都是大写，比如"USA"。
//    单词中所有字母都不是大写，比如"leetcode"。
//    如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
//    否则，我们定义这个单词没有正确使用大写字母。


    public static boolean detectCapitalUse(String word) {




        if(word.length()==0 ||  word==null){
            return false;
        }
       //全部大写是正确的，首字母大写，其余全部小写正确  所有都小写 正确
        int count=0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c >= 'A' && c<='Z'){
                count++;
            }
        }
        //全部小写字母 或者全部字母都是大写
        if(count==0 || count==word.length()){
            return true;
        }

        //count=1表示只有一个大写字母，这里要限定这个字母是首字母
        if(count==1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' ){
            return  true;
        }
        return false;

    }

    public static void main(String[] args) {


        System.out.println(detectCapitalUse("ASDF"));
        System.out.println(detectCapitalUse("asdf"));
        System.out.println(detectCapitalUse("aAdf"));

    }




}
