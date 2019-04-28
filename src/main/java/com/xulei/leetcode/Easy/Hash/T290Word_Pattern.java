package com.xulei.leetcode.Easy.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词模式
 */
public class T290Word_Pattern {


//    给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
//
//    这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
//
//
//    示例1:
//
//    输入: pattern = "abba", str = "dog cat cat dog"
//    输出: true
//    示例 2:
//
//    输入:pattern = "abba", str = "dog cat cat fish"
//    输出: false
//    示例 3:
//
//    输入: pattern = "aaaa", str = "dog cat cat dog"
//    输出: false
//    示例 4:
//
//    输入: pattern = "abba", str = "dog dog dog dog"
//    输出: false

    public static boolean wordPattern(String pattern, String str) {

        /**
         * 思路：
         *
         * 使用spilt切割下，然后用map做映射关系，其中key是模式，value是每一个字符。要一一对应上
         *
         *
         * 判断切割后的数组与匹配模式是不是大小一样
         *
         * 遍历这个字符串数组，如果key不存在，再放入过程中，
         *
         * 还需要判断这个value是不是存在，为啥尼？如果有，说明这个key不同的情形下，存在相同的value
         *
         * 是错误的，因为key和这个value必须是一一对应，
         *
         *
         * 如果没有重复的value，就放入。
         * 如果key存在，则取出已经存在的key所对应的value，如果value不相同，那么就出现了同样的key对应不同的value
         *
         * 也是错误的，只有同样的key对应同样的value才是可以的
         *
         */
        String[] split = str.split(" ");
        if(split.length!=pattern.length()){
            return false;
        }

        Map<Character,String> map=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(split[i])){
                    return false;
                }
            }else{
                if( map.containsValue(split[i])){
                    return false;
                }
                map.put(c,split[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {





    }



}
