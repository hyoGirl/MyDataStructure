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


    /**
     *
     * 如果栈不是空的，先把根节点入栈，然后就是组左子树入栈，左边全部入栈完毕后，
     * 弹出，然后再弹出根节点，跟节点弹出后。接着就是右边子树入栈，右边入栈完毕后，再弹出
     *
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();


        //这个地方有错误，输入[] 返回的却是null。结果应该是[].应该修改为返回resList
//        if (root == null) {
//            return null;
//        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resList.add(root.val);
            //不需要判断root的右边子树是不是为空。因为上面的循环在判断
            root = root.right;
        }
        return resList;
    }
}
