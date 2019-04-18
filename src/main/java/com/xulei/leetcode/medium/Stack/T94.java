package com.xulei.leetcode.medium.Stack;

import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class T94 {


//    给定一个二叉树，返回它的中序 遍历。


    /**
     *
     * 二叉树的中序遍历：就是左根右
     *
     * 用栈来实现
     *
     * 中序遍历 先遍历左子树->根节点->右子树
     *
     * 如果是递归做法则递归遍历左子树，访问根节点，递归遍历右子树
     *
     * 非递归过程即:先访问..最左子树..结点，再访问其父节点，再访问其兄弟
     * while循环条件 中序遍历需先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
     * 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
     */

    public List<Integer> inorderTraversal(TreeNode root) {





    }

}
