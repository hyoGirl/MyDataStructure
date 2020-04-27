package com.xulei.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XULEI
 * @ClassName MyTree
 * @description https://blog.csdn.net/qq_22494029/article/details/79074206
 * @Date 2020/4/27 21:01
 * @Version 1.0
 */
public class MyTree {


    // 临时存储数据
    private static  List<MyNode> temps=new ArrayList<>();


    //完全二叉树 编号为i的节点与同样深度的满二叉树编号为I的相同，就是完全二叉树

    // https://blog.csdn.net/Barnetthe/article/details/52459104

    // 创建一个完美的二叉树  满二叉树
    public  static  void createTree(int[] data){
       if(data.length==0){
           return ;
       }
        int length = data.length;
        // 生成二叉树节点
        for (int i = 0; i < length; i++) {
            temps.add(new MyNode(data[i]));
        }
        // 按照完美的二叉树来创建  数组下标从0开始计算的，但是二叉树的第一位是根，左边是奇数，右边就是偶数 下标了
        int size=length/2-1;
        // 注意，这里没有写等号，是为了保证前面的父节点都能有左右子树
        for (int i = 0; i < size; i++) {
            if(null!=temps.get(i*2+1)){
                temps.get(i).leftNode=temps.get(i*2+1);
            }
            if(null!=temps.get(i*2+2)){
                temps.get(i).rightNode= temps.get(i*2+2);
            }
        }
        // 最后一个父亲节点，不一定有孩子   length/2-1  就是最后一个父亲节点的下标
        int lastParentIndex =length/2-1;
        MyNode node =temps.get(lastParentIndex );
        node.leftNode=temps.get(lastParentIndex *2+1);
        if(length%2==1){
            // 总节点个数是奇数的时候，才有右边的孩子
            node.rightNode=temps.get(lastParentIndex*2+2);
        }
    }


    public static void main(String[] args) {
        int[] arr={1,2,4,6,3,8,12};
        MyTree tree=new MyTree();
        tree.createTree(arr);

//        prePrint(temps.get(0));

        inOrderPrint(temps.get(0));

    }

    public static void prePrint(MyNode node){
        if(null!=node){
            System.out.println("node-->" +node.getData());
            prePrint(node.leftNode);
            prePrint(node.rightNode);
        }else{
            return;
        }

    }

    // 中序遍历  左 根 右
    public static void inOrderPrint(MyNode node){
            if(null==node){
                return ;
            }
            MyNode leftNode = node.leftNode;
            if(null!=leftNode){
                inOrderPrint(leftNode);
            }
            System.out.println("node-->" +node.data);
            MyNode rightNode = node.rightNode;
            if(null!=rightNode){
                inOrderPrint(rightNode);
            }
    }
}
