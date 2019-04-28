package com.xulei.leetcode.Easy.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数字之和
 */
public class T01 {

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//
//
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> data=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key=target-nums[i];
            if(data.containsKey(key)){
                return new int[]{i,data.get(key)};
            }
            data.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有符合的数据");
    }




}
