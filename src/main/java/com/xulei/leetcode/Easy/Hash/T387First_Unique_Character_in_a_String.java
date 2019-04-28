package com.xulei.leetcode.Easy.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName T387First_Unique_Character_in_a_String
 * @description TODO
 * @Date 2019/4/23 23:44
 * @Version 1.0
 */
public class T387First_Unique_Character_in_a_String {

    public int firstUniqChar(String s) {

        /**
         * 思路：
         *
         * 遍历每一个数组元素，放到这个map中，如果重复就+1
         *
         * 如果不重复，就设置为1
         *
         *
         * 再次便利这个数组，如果获取到的value是1，就返回
         */

        char[] chars = s.toCharArray();

        Map<Character,Integer> map=new HashMap<>();


        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(map.containsKey(aChar)){
                map.put(aChar,map.get(aChar)+1);
            }else{
                map.put(aChar,1);
            }
        }

        for (int j = 0; j < chars.length; j++) {

            char aChar = chars[j];

            if(map.get(aChar)==1){
                return j;
            }
        }
        return -1;



    }
}
