package com.xulei.leetcode.Easy.LinkedList;

/**
 * @author ashura1110
 * @ClassName T21MergeTwoSortedLists
 * @description TODO
 * @Date 2019/6/11 22:46
 * @Version 1.0
 */
public class T21MergeTwoSortedLists {

    /**
     * 合并两个有序连表
     * <p>
     * https://blog.csdn.net/o9109003234/article/details/84245783
     */


    /**
     * 递归方式实现
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //设置合并后的连表
        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        }
        if (list1.val > list2.val) {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;


    }

    /**
     * 非递归方式来实现
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode<Integer> list1, ListNode<Integer> list2) {

        ListNode<Integer> node1 = new ListNode<>(0);
        ListNode<Integer> current = node1;
        //如果连表A的第一个节点小于连表B的第一个节点
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        }
        if (list2 == null) {
            current.next = list1;
        }
        //重点，这里不再是current了
        return node1.next;
    }


    public static void main(String[] args) {

        ListNode<Integer> list1 = new ListNode<>(1);
        ListNode<Integer> list11 = new ListNode<>(2);

        list1.next = list11;

        ListNode<Integer> list2 = new ListNode<>(1);
        ListNode<Integer> list21 = new ListNode<>(3);

        list2.next = list21;

//        ListNode listNode1 = mergeTwoLists(list1, list2);

        ListNode listNode1 = mergeTwoLists2(list1, list2);

        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }


    }


}


