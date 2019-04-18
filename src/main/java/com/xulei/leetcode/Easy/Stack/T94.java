package com.xulei.leetcode.Easy.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ashura1110
 * @ClassName T94
 * @description TODO
 * @Date 2019/4/18 23:02
 * @Version 1.0
 */
public class T94 {

    /**
     * 二叉树的中序遍历
     * <p>
     * <p>
     * 中序：  左 根 右
     * <p>
     * 逻辑：一直要左边遍历完毕后，才能访问根节点，接下来才是访问右边节点
     */


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null || root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            resList.add(pop.val);
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }
        }

        return resList;
    }
}
