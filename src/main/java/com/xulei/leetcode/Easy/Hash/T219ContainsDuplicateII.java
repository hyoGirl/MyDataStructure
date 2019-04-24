package com.xulei.leetcode.Easy.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class T219ContainsDuplicateII {


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=nums[i];
            if(!map.containsKey(temp)){
                map.put(temp,i);
            }else{
                Integer count = map.get(temp);
                if(Math.abs(i-count)<=k){
                    return true;
                }
                //为啥要再次放进来尼，就是可能存在多次重复的，这次不行，下次还可以继续
                //例子： [1,0,1,1]  1
                map.put(temp,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {


        int[] nums={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));


    }
}
