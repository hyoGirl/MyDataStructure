package com.xulei.dataStructure.tree;

import java.util.*;

/**
 * @author XULEI
 * @ClassName MyTree
 * @description https://blog.csdn.net/qq_22494029/article/details/79074206
 * @Date 2020/4/27 21:01
 * @Version 1.0
 */
public class MyTree {


    public static void main(String[] args) {
        int[] arr={1,2,4,6,3,8,12};
        MyTree tree=new MyTree();
        tree.createTree(arr);
//        prePrint(temps.get(0));
//        inOrderPrint(temps.get(0));
//        prePrint2(temps.get(0));
//        inOrderPrint2(temps.get(0));

//        cengXu(temps.get(0));

        inOrderPrint2(temps.get(0));

    }



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
        // 构建二叉树 根节点n[i] 左子树n[i*2+1] 右子树 n[i*2+2]
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




    public static void prePrint(MyNode node){
        if(null!=node){
            System.out.println("node-->" +node.getData());
            prePrint(node.leftNode);
            prePrint(node.rightNode);
        }else{
            return;
        }

    }
    //非递归前序遍历 前序遍历 是 根 左右   使用栈， 根 进去，出来 右边进去 左边进去，左边出来，右边出来
    public static void prePrint2(MyNode node){
        Stack<MyNode> stack=new Stack<>();
        if(null!=node){
            stack.push(node);
            while(!stack.isEmpty()){
                MyNode myNode = stack.pop();
                print(myNode);
                if(null!=myNode.rightNode){
                    stack.push(myNode.rightNode);
                }
                if(null!=myNode.leftNode){
                    stack.push(myNode.leftNode);
                }
            }
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

    /**
     * 中序遍历，非递归  中序遍历，就是左 根 右 一定要左边子树全部访问完毕，才去访问根，根访问完毕了，再去访问右边
     * 此时右边又变成了根。所以，先根入栈，左边入栈， 左边出站 根出站  然后右边入栈
     * 一定要先全部压左边
     * @param node
     */
    public static void inOrderPrint2(MyNode node){
        if(null==node){
            return ;
        }
        Stack<MyNode> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            while (null!=node.leftNode && null!=node){
                stack.push(node.leftNode);
                node=node.leftNode;
            }
            node=stack.pop();
            print(node);
            if(null!=node.rightNode){
                node=node.rightNode;
                stack.push(node);
            }
        }
    }

    /**
     * 层序遍历二叉树
     * @param node
     */
    public static void cengXu(MyNode node){
        /**
         * 每一个根节点，都可能有左右子树，先把当前的节点的左右子树放入队列中
         * 然后，把当前节点弹出，接下来头部就是兄弟节点了，此时，在把自己节点的左右子树放入，循环就好
         */
        if(null == node){
            return ;
        }
        Queue<MyNode> queue=new  LinkedList<MyNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            MyNode myNode = queue.poll();
            print(myNode);
            if(null!=myNode.leftNode){
                queue.add(myNode.leftNode);
            }
            if(null!=myNode.rightNode){
                queue.add(myNode.rightNode);
            }
        }
    }

    /**
     * 获取二叉树的宽度 二叉树的宽度是指含有最多节点数的对应层对应的节点数
     * @return
     */
    public static Integer getWidth(){


        /**
         * 先设置临时变量，保存当前队列的长度，如果值为0 就表示该层全部弹出了，此时剩下的值就是下一层的最大数
         */

        return 0;

    }




    public static void print(MyNode node){
        System.out.println("node-->" +node.getData());
    }





}
