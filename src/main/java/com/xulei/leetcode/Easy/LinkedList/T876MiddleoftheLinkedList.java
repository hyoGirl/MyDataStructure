package com.xulei.leetcode.Easy.LinkedList;

import com.xulei.dataStructure.List.linkedList.single.HeadSingleLinkedList;

/**
 * @author ashura1110
 * @ClassName T876MiddleoftheLinkedList
 * @description TODO
 * @Date 2019/6/13 22:08
 * @Version 1.0
 */
public class T876MiddleoftheLinkedList {

    /**
     * 查找连表的中间节点
     * @param head
     * @return
     */

    /*
      1：使用快慢指针，一个A是第三位  一个B是第二位

      差别之处在于，增加判断条件A的下一位不是null

      1：假如是 1 2 3 4 5    此时结果获取的必须是3

      2： 假如是 1 2 3 4  一开始 A 是3 A的下一位是4 B变成了2 此时A变成了4 A的下一位没有了，B变成了3
     */
    public static ListNode middleNode(ListNode head) {

        if(head==null){
            return null;
        }
        ListNode fast=head.next.next;
        ListNode low=head.next;
        //核心方法在于，此时必须是fast不是null  fast.next不是null
        while (fast!=null && fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }


    /**
     * 计算node节点的个数方法
     * @param head
     * @return
     */
    public  static ListNode  middleNode2(ListNode head){
        if(head==null){
            return null;
        }
       int count=getSize(head);
        int num=(1+count)/2;
        int len=0;
        while(len< num){

            head=head.next;
            len++;
        }
        return head;
    }

    private static int getSize(ListNode head) {

        int a=0;
        while(head!=null){
            a++;
            head=head.next;
        }
        return a;
    }

    public static void main(String[] args) {

        ListNode<Integer> listNode1 = new ListNode<>(1);
        ListNode<Integer> listNode2 = new ListNode<>(2);
        ListNode<Integer> listNode3 = new ListNode<>(3);
        ListNode<Integer> listNode4 = new ListNode<>(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;


        System.out.println(middleNode2(listNode1).val);
        System.out.println(middleNode(listNode1).val);


    }
}
