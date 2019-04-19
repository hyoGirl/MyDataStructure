package com.xulei.leetcode.Easy.Stack;


import com.xulei.dataStructure.Queue.LinkedQueue;
import com.xulei.dataStructure.Queue.Queue;

/**
 * 用队列来实现栈
 */
public class T225 {



    /**
     *
     * queue
     *
     * add  添加元素
     * poll  返回头部元素，并且移除
     * peek  弹出头部元素，不移除
     *
     *
     *  用两个队列，始终保持一个队列是空的
     *  入栈，就是直接往非空的队列中添加，如果都是空，就选择一个
     *  出站，要完成先进后出。队列本身是先进先出，就相当于排队
     *
     *    所以只要把一个队列中的前n-1个数据放到第二个队列中.然后返回最后一个元素。就实现了先进后厨
     *
     *    等到要弹倒数第二个数据的时候，把第二个队列中n-1的数据再放到第一个中，然后返回剩下的一个，就是最后的了
     *
     */

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size;


    public T225(){

        this.queue1=new LinkedQueue<Integer>();
        this.queue2=new LinkedQueue<Integer>();
        this.size=0;

    }

    /**
     *  Push element x onto stack.
     */

    void push(int x) {


        /**
         * 判断那个队列是空的。就放到里面
         */
        if(queue1.peek()!=null){
            queue1.offer(x);
        }else if(queue2.peek()!=null){

            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
        size++;
    }

    /** Removes the element on top of the stack and returns that element.移除栈顶元素 */
    /**
     * 思路就是：把前n-1个元素放到一个队列中，剩下的元素就是栈顶元素
     * @return
     */
    int pop() {
      int  e=0;
      if(queue1.peek()!=null){
          for(int i=0;i<size-1;i++){
              queue2.offer(queue1.poll());
          }
          e=queue1.poll();
      }
      if(queue2.peek()!=null){
          for(int i=0;i<size-1;i++){
              queue1.offer(queue2.poll());
          }
          e=queue2.poll();
      }

      this.size--;
      return e;
    }


    /** Get the top element. 获取栈顶元素*/
    /**
     *
     * 和上面的区别在于：上面只剩下一个，在队列，这样可以保证取的最后的一个值。实现先进后出
     *
     * 这个区别在于：不停遍历，获取最后一个值，然后把这个值返回，就是栈顶元素
     *
     * @return
     */
    int top() {
        int e=0;
        if(queue1.peek()!=null){
            for(int i=0;i<size;i++){
                e=queue1.poll();
                queue2.offer(e);
            }
        }
        if(queue2.peek()!=null){
            for(int i=0;i<size;i++){
                e=queue2.poll();
                queue1.offer(e);
            }
        }
        return e;
    }


    public boolean empty() {
        return size == 0;
    }


    public int size(){
        return this.size;
    }

}
