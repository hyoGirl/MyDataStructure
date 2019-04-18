package com.xulei.leetcode.Easy.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集
 */
public class T350 {


//    输入: nums1 = [1,2,2,1], nums2 = [2,2]
//    输出: [2,2]



    public static int[] intersect(int[] nums1, int[] nums2) {


        List<Integer> list1=new ArrayList<>();
        for(int num:nums1){
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();


        for(int num:nums2){
            if(list1.contains(num)){
                list2.add(num);
                list1.remove(Integer.valueOf(num));
            }
        }


        int[] res=new int[list2.size()];
        int index=0;
        for(int count:list2){
            res[index++]=count;
        }
        return  res;
    }


    public static void main(String[] args) {


        int[]nums1 = {1,2,2,1};
        int[]nums2 = {2,2};
        int[] res=intersect(nums1,nums2);
        System.out.println(Arrays.toString(res));


    }

}
