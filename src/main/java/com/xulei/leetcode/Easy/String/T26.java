package com.xulei.leetcode.Easy.String;

import java.util.Arrays;

/**
 * 删除排序数组中的重复元素
 */
public class T26 {


//    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。


//    给定数组 nums = [1,1,2],
//
//    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//    你不需要考虑数组中超出新长度后面的元素。   其实意思是新的数组变成了[1,2,2]但是前面的2个元素不是重复的

    /**
     * i指向已排序区间的末尾，用j遍历数组，与a[i]对比，
     * 如果不相同就插入到已排序区间末尾
     */


    public static int removeDuplicates(int[] nums) {


        /**
         *
         * 1:依次遍历数组中的每一个元素，如果这个元素和已经排好序的数组不一样，
         *
         * 那么就重头开始，把这个元素放到这个已经拍好序的末尾。相当于重新排序
         *
         */

        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                ++i;
                nums[i] = nums[j];
            }
        }
        return ++i;

    }


    public static void main(String[] args) {

        int[] arr={1,2,3,3,4};


        System.out.println(Arrays.toString(arr));

        removeDuplicates(arr);

        System.out.println(Arrays.toString(arr));

    }

}
