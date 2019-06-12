package com.xulei.leetcode.Easy.LinkedList;

import com.xulei.leetcode.Easy.Stack.TreeNode;

import java.util.concurrent.Delayed;

/**
 * @author ashura1110
 * @ClassName T83RemoveDuplicatesfromSortedList
 * @description TODO
 * @Date 2019/6/12 22:17
 * @Version 1.0
 */
public class T83RemoveDuplicatesfromSortedList {

    /**
     * 删除链表中的重复元素
     */

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 递归方式来解决
     * @return
     */
    public  static  ListNode deleteDuplicates2(ListNode head){

        if(head==null || head.next==null){
            return null;
        }
        if(head.val==head.next.val){
            head.next=head.next.next;
            deleteDuplicates2(head);
        }else{
            deleteDuplicates2(head.next);
        }
        return head;



    }

    public static void main(String[] args) {


        ListNode<Integer> listNode1 = new ListNode<>(1);
        ListNode<Integer> listNode2 = new ListNode<>(1);
        ListNode<Integer> listNode3 = new ListNode<>(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

//        ListNode listNode = deleteDuplicates(listNode1);
        ListNode listNode = deleteDuplicates2(listNode1);


        while (listNode != null) {

            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }


    }


}
