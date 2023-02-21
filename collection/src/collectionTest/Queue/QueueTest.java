package collectionTest.Queue;
import java.util.*;

/*
* Queue��һ���ӿڣ��̳���Collection������Queue�ķ��������Ҷ�������ʹ����Collection�еķ�����Ҳ����ʵ�ֻ�������
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
        Queue<String> q = new LinkedList<>();//�ýӿڱ���������ʵ�������ʱ�����ʱ������ʹ�ýӿ������еķ�����ʵ�����Լ��ķ�������ʹ��
        //���Դ�ʱ��q��ʾ���ݽṹΪ����Ķ���
        /*���Ԫ��
        ����һЩ�������н�ģ�
        * ����1��offer()���ڶ���β������Ԫ�أ�����������˲������᷵��false��ȡ����β���
        * ����2��add()���ڶ���β������Ԫ�أ��������������ᱨ��
        * */
        q.offer("aaa");
        q.add("bbb");
        /*ɾ��Ԫ��
         * ����1��poll()����ͷ��Ԫ�شӶ�����ɾ�������ҷ��ء��������Ϊ�գ��򷵻�null��
         * ����2��remove()����ͷ��Ԫ�شӶ�����ɾ�������ҷ��ء��������Ϊ�գ������쳣��
         * */
        /*����ͷ��Ԫ��
         * ����1��peek()������ͷ��Ԫ�ء��������Ϊ�գ��򷵻�null��
         * ����2��element()������ͷ��Ԫ�ء��������Ϊ�գ������쳣��
         * */
        q.size();//collection�еķ��������ض��еĳ���





    }
}
