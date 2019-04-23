package com.xulei.leetcode.Easy.Hash;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ashura1110
 * @ClassName T136SingleNumber
 * @description TODO
 * @Date 2019/4/23 23:09
 * @Version 1.0
 */
public class T136SingleNumber {

//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。


    public int singleNumber(int[] nums) {

        /**
         * 异或运算
         *
         * 1:任何数和0异或都是自身， 任何数于0异或为任何数 0 ^ n => n
         * 2：相同的数字异或结果是0  相同的数异或为0: n ^ n => 0
         * 3：异或顺序变化无所谓  交换律：a ^ b ^ c <=> a ^ c ^ b
         *
         * [2,3,2,4,4]  2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
         */
        int res=0;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }


    public  int singleNumber2(int[] nums){

        Set<Integer> set=new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        int res=0;
        for (int j = 0; j < nums.length; j++) {
            if(set.contains(nums[j])){
                res=nums[j];
                break;
            }
        }
        return res;

    }


    public  void  change(){
        int a=3,b=4;

        a=a^b;
        b=a^b;

        a=a^b;



    }
}
