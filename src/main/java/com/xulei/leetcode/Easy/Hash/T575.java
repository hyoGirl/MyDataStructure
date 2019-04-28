package com.xulei.leetcode.Easy.Hash;

import java.util.HashSet;

/**
 * 分糖果
 */
public class T575 {


//    给定一个偶数长度的数组，
//    其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
//    你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
//
//    极端最大情况：每种糖果都不重复，每种都给妹妹一个，都不重复。那妹妹只能拿到一半数量
//    极端2：每一种糖果都有两个，每种给妹妹一个，妹妹获取一半
//    极端最小：就一种糖果，妹妹拿到一个后，后面都是重复的。
//
//
//    思想：不管多少种，先每一种都给妹妹一个，如果才给了妹妹几个，所有种类都过了，那就是重复的。
//
//    如果给到了一半，还不重复，那么妹妹也只能最多获取一半了。

//    本质上，都不重复，一个人也只能获取到一半的数量，所以实际上就是比较种类数目和一半数量的大小，


    public static int distributeCandies(int[] candies) {

        HashSet<Integer> set=new HashSet<>();

        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return Math.min(set.size(),candies.length/2);
    }


    public static void main(String[] args) {

//       int[] candies = {1,1,2,2,3,3};
       int[] candies = {1,1,2,2,3,3};
//       int[] candies = {1,1,2,2,1,1};
        System.out.println(distributeCandies(candies));

    }

}
