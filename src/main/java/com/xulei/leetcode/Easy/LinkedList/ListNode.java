package com.xulei.leetcode.Easy.LinkedList;

/**
 * @author ashura1110
 * @ClassName ListNode
 * @description TODO
 * @Date 2019/6/11 22:47
 * @Version 1.0
 */
public class ListNode<T> {

    //数据域
    T val;

    //指针域
    ListNode<T> next;

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode() {
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }



//    public  ListNode<T> init(){
//
//        ListNode<T> node=new ListNode<>();
//
//        node.next=null;
//
//
//
//
//
//    }

}
