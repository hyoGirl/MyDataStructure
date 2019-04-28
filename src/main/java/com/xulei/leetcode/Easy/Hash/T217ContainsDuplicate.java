package com.xulei.leetcode.Easy.Hash;

import java.util.HashSet;

/**
 *  217. 存在重复元素
 */
public class T217ContainsDuplicate {


//    给定一个整数数组，判断是否存在重复元素。
//
//    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
//
//
//    输入: [1,2,3,1]
//    输出: true


    /**
     * 其实只需要判断这个数组中存在一组重复数字就可以了。可以用set
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size()==nums.length){
            return false;
        }else{
            return true;
        }
    }


    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }


}
