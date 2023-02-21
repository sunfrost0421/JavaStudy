package collectionTest.Queue;
import java.util.*;

/*
* Queue是一个接口，继承于Collection，但是Queue的方法完整且独立，即使不用Collection中的方法，也可以实现基本功能
*
*
* */
public class QueueTest
{
    public static void printQ(Queue queue)
    {
        while(queue.peek() != null)
        {
            System.out.println(queue.remove()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();//用接口变量来引用实现类对象时，这个时候智能使用接口引用中的方法，实现类自己的方法不能使用
        //所以此时的q表示数据结构为链表的队列
        /*添加元素
        （有一些队列是有界的）
        * 方法1：offer()，在队列尾部插入元素，如果容量满了插入错误会返回false且取消这次操作
        * 方法2：add()，在队列尾部插入元素，如果容量满了则会报错
        * */
        q.offer("aaa");
        q.add("bbb");
        /*删除元素
         * 方法1：poll()，将头部元素从队列中删除，并且返回。如果队列为空，则返回null。
         * 方法2：remove()，将头部元素从队列中删除，并且返回。如果队列为空，则抛异常。
         * */
        /*返回头部元素
         * 方法1：peek()，返回头部元素。如果队列为空，则返回null。
         * 方法2：element()，返回头部元素。如果队列为空，则抛异常。
         * */
        q.size();//collection中的方法，返回队列的长度





    }
}
