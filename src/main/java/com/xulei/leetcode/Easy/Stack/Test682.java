package com.xulei.leetcode.Easy.Stack;

import java.util.Stack;

/**
 * 棒球比赛
 */
public class Test682 {

//
//    你现在是棒球比赛记录员。
//    给定一个字符串列表，每个字符串可以是以下四种类型之一：
//            1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
//            2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
//            3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
//            4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
//
//    每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
//    你需要返回你在所有回合中得分的总和。
//
//
//    输入: ["5","2","C","D","+"]
//    输出: 30
//    解释:
//    第1轮：你可以得到5分。总和是：5。
//    第2轮：你可以得到2分。总和是：7。
//    操作1：第2轮的数据无效。总和是：5。
//    第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
//    第4轮：你可以得到5 + 10 = 15分。总数是：30。



    public  int getSum(String[] ops){


        int[] arr=new int[ops.length];
        int i=0;
        for(String str:ops){
            switch (str) {
                case "+":
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                case "C":
                    arr[i - 1] = 0;
                    i--;  //这里用i--是因为要删除分数.不然统计出问题
                    break;
                case "D":
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                default:
                    arr[i] = Integer.valueOf(str);
                    i++;
                    break;
            }
        }
        int sum=0;
        for(int j=0;j<arr.length;j++){

            sum+=arr[j];
        }

        return  sum;
    }


    public int getSum2(String[] ops){

        Stack<Integer> stack=new Stack<>();
        int res=0;


     for(int i=0;i<ops.length;i++){
         if(ops[i].equals("C")){
            int t=stack.peek();
            stack.pop();
            res-=t;
         }
        else if(ops[i].equals("D")){
             int t=stack.pop();
             res+=t*2;
             stack.push(t*2);
         }
        else if(ops[i].equals("+")){
            int t1=stack.pop();
            int t2=stack.peek();
            int t=t1+t2;
            stack.push(t1);
            stack.push(t);
            res+=t;
         }else{
             int t=Integer.valueOf(ops[i]);
             stack.push(t);
             res+=t;
         }
     }
        return res;
    }
}
