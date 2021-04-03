package Java0403;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wgsstart
 * @creat 2021-04-03 20:30
 */
public class MyStackBy2Queue {
   private Queue<Integer> A = new LinkedList<>();//造一个A队列
    private Queue<Integer> B = new LinkedList<>();//再造一个B队列
   public void push(int x){//入栈
    //x往A中入队列即可
       A.offer(x);
   }
   public Integer pop(){//出栈
    if(empty()){
        return null;
    }
    //把A中的元素往B中倒腾
       while (A.size() > 1){
        Integer front = A.poll();
        B.offer(front);
       }
       //当循环结束之后，A中应该就是1个元素；这个元素就是应该被出栈的元素
       int ret = A.poll();
    //交换A和B的身份
       swapAB();
       return ret;
   }
   private void swapAB(){
       Queue<Integer> tmp = A;
       A = B;
       B = tmp;
   }
   public Integer top(){//取队首元素
       if(empty()){
           return null;
       }
       //把A中的元素往B中倒腾
       while (A.size() > 1){
           Integer front = A.poll();
           B.offer(front);
       }
       //当循环结束之后，A中应该就是1个元素；这个元素就是应该被出栈的元素
       int ret = A.poll();
       B.offer(ret);//top 和 pop 唯一的区别就是这句话
       //交换A和B的身份
       swapAB();
       return ret;
   }
   public boolean empty(){//判断栈是否为空
        return A.isEmpty() && B.isEmpty();
   }
}
