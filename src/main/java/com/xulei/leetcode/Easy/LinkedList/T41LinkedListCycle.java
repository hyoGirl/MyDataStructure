package com.xulei.leetcode.Easy.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ashura1110
 * @ClassName T41LinkedListCycle
 * @description TODO
 * @Date 2019/6/12 23:00
 * @Version 1.0
 */
public class T41LinkedListCycle {
    /**
     * 判断连表是否有环
     */

    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用set集合来实现
     * @param head
     * @return
     */
    public  static  boolean hasCycle2(ListNode head){

        Set<ListNode> set=new HashSet<ListNode>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
            head=head.next;
        }
        return  false;
    }



    public static void main(String[] args) {


        ListNode<Integer> listNode1 = new ListNode<>(3);
        ListNode<Integer> listNode2 = new ListNode<>(2);
        ListNode<Integer> listNode3 = new ListNode<>(0);
        ListNode<Integer> listNode4 = new ListNode<>(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        listNode4.next=listNode2;

//        boolean b = hasCycle(listNode1);
        boolean b = hasCycle2(listNode1);

        System.out.println(b);


    }




}
