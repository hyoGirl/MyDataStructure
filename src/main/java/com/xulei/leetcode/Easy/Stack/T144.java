package com.xulei.leetcode.Easy.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ashura1110
 * @ClassName T144
 * @description TODO
 * @Date 2019/4/18 21:38
 * @Version 1.0
 */
public class T144 {


    /**
     * 前序遍历二叉树，实现，
     * <p>
     * 前序遍历，就是根 左 右
     * <p>
     * 使用栈来实现，先是根入栈，如果栈不是空，就出栈，然后右边入栈，如果左子树不是空，左边入栈
     * <p>
     * 如果栈不是空，那么就出栈，此时就是左子树出来，左子树此时就是根了，然后，就是右边子树出来
     */


    public List<Integer> preorderTraversal(TreeNode root) {


        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                resList.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        } else {
            return resList;
        }
        return resList;
    }


}
