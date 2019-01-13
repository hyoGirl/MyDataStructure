package com.xulei.leetcode.Easy.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ashura1110
 * @ClassName TwoSum
 * @description  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @Date 2019/1/6 20:47
 * @Version 1.0
 */
public class TwoSum {


    public static void main(String[] args) {

        int[] arr={2,3,4};
        int[] ints = twoSum(arr, 6);

        for(int i=0;i<ints.length;i++){
            System.out.println(arr[ints[i]]);
        }

        System.out.println(Arrays.toString(ints));
    }

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。


    /**
     * 使用一遍Hash 。在进行迭代遍历的过程中，把每一个元素作为key放在这个map中，value就是下标
     * 然后用目标值，减去每一个元素的值，获取差值，如果差值也在这个map中，就说明存在一组数，满足和为目标值。
     *
     *  这组数目的下标  一个是正在遍历的树的下标，一个是差值的下标，差值的下标其实就是差值对应的最开始的map的value
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {


            //要排除重复元素，上面的例子中 3 就是不合适的，如果map放在第一位，那么正好map又包含了这个差值，导致结果出错

            //所以要排除差值和现在的值是同一种的情况

//            map.put(nums[i], i);
            int complement = target - nums[i];
            //判断这个元素是否存在map中，如果存在，就返回。
            //由于是在第一次便利中，所以map还是空，根本不满足。
            //当下一次遍历的时候，map中已经存在值了，假如满足，那差值其实就是以前存在map中的值，和当前遍历的值能满足条件
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}



