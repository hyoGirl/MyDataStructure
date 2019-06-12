package com.xulei.data02.List;

/**
 * @author ashura1110
 * @ClassName SeqList
 * @description TODO
 * @Date 2019/6/11 22:20
 * @Version 1.0
 */
public class SeqList {

    //顺序表的大小
    int length;

    //数组声明,用于存储元素
    Object[] data;

    public  SeqList(int capacity){

        this.data=new Object[capacity];
        this.length=0;
    }

}
