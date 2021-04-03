package Java0403;

import java.util.Stack;

/**
 * @author wgsstart
 * @creat 2021-04-03 22:47
 */
public class MyQueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();
    public void push(int x){
       //1.先把 B 中的元素都 倒腾到A里
        while (!B.isEmpty()){
            int tmp = B.pop();
            A.push(tmp);
        }
        //2.把新元素入A即可
        A.push(x);
    }
    public Integer pop(){
        //1.如果为空就直接返回
        if(empty()){
            return null;
        }
        //2.把A中的元素都倒腾给B
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        //3.针对B进行出栈
        return B.pop();
    }
    public Integer peek(){
        //1.如果为空就直接返回
        if(empty()){
            return null;
        }
        //2.把A中的元素都倒腾给B
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        //3.直接取B的栈顶元素
        return B.peek();
    }
    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
