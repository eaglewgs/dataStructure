package Java0320;

/**
 * @author wgsstart
 * @creat 2021-04-03 12:49
 */
public class MyQueueByArray {
    private int[] array = new int[100];
    //[head,tail)有效范围的元素。注意，tail 可能在 head 之前
    private int head = 0;
    private int tail = 0;
    private int size = 0;//元素个数
    public void offer(int val){//入队列
        if(size == array.length){
            //队列满了，无法继续插入
            return;
        }
        array[tail] = val;//得保证这个操作下标不能越界
        tail++;
        //tail++之后如果超出了数组的有效范围，就从头开始
        if(tail >= array.length){
            tail = 0;
        }
        size++;
    }
    public Integer poll(){//出队列
        if(size == 0){
            return null;
        }
        Integer ret = array[head];
        head++;
        if(head >= array.length){
            head = 0;
        }
        size--;
        return ret;
    }
    public Integer peek(){//取队首元素
        if(size == 0){
            return null;
        }
        return array[head];
    }
}
