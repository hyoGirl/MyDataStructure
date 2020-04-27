package com.xulei.dataStructure.tree;


/**
 * @author XULEI
 * @ClassName MyNode
 * @description TODO
 * @Date 2020/4/27 21:04
 * @Version 1.0
 */
public class MyNode {

    public Integer data;

    public MyNode leftNode;

    public MyNode  rightNode;

    public MyNode(Integer value,MyNode leftNode,MyNode  rightNode){
        this.data=value;
        this.leftNode=leftNode;
        this.rightNode=rightNode;
    }

    public MyNode(Integer value){
        this.data=value;
    }

    public MyNode(){
    }
    public Integer getData(){
        return data;
    }

    public void setData(Integer value){
        this.data=value;
    }


    public MyNode getLeftNode(){
        return this.leftNode;
    }

    public void setLeftNode(MyNode leftNode){

        this.leftNode=leftNode;
    }


    public  MyNode getRightNode(){
        return this.rightNode;
    }

    public void setRightNode(MyNode rightNode){
        this.rightNode=rightNode;
    }

}
