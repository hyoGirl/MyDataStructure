package com.xulei.leetcode.Easy.Stack;

/**
 * @author ashura1110
 * @ClassName TreeNode
 * @description TODO
 * @Date 2019/4/18 21:44
 * @Version 1.0
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;


    TreeNode(int x){
        this.val=x;
    }


    TreeNode (int x ,TreeNode left,TreeNode right){
        this.val=x;
        this.left=left;
        this.right=right;
    }
}
