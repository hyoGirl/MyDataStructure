package com.xulei.leetcode.Easy.LinkedList;


/**
 * @author ashura1110
 * @ClassName SingleLinkedList
 * @description TODO
 * @Date 2019/6/11 23:21
 * @Version 1.0
 */
public class SingleLinkedList<T> {

    ListNode<T> head;

    public SingleLinkedList(ListNode<T> head){

        this.head=head;
    }


    /**
     * 1:第一次插入
     * 2：尾部插入
     * 3：指定地点插入
     * @param index
     * @param data
     * @return
     */
    public  boolean  addNode(int index,T data){

        if(data==null){
            return false;
        }
        //判断采用什么插入方法
        if(this.head==null){
            this.head=new ListNode<>(data,null);
        }else{
            int count=0;
            ListNode node=head;
            //获取指定下标的前面一位
            while (node.next!=null && count < index){
                node=node.next;
                count++;
            }
            if(node!=null){
                node.next=new ListNode(data,node.next);
            }
            return true;
        }
        return false;
    }

    public  boolean add(T data){
        return addNode(Integer.MAX_VALUE,data);
    }


    public  String toString(){

        String str="(";

        ListNode curr=this.head;
        while (curr!=null){

            str+=curr.val;
            curr=curr.next;
            if(curr!=null){
                str+=",";
            }
        }
        return str+=")";
    }


    public  SingleLinkedList(T data){

        this.head=new ListNode<>(data);
    }


    public static void main(String[] args) {


        SingleLinkedList<Integer> singleLinkedList=new SingleLinkedList<>(1);

        singleLinkedList.add(2);
        singleLinkedList.add(4);


        System.out.println(singleLinkedList.toString());


        SingleLinkedList<Integer> list2=new SingleLinkedList<>(1);

        list2.add(2);
        list2.add(3);

        System.out.println(list2.toString());





    }

}
