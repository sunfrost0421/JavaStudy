package collectionTest.Queue;

/*���ȼ����У�ÿ���ó���Ԫ�ض������ȼ���ߵ�Ԫ��
* ���ȼ�������Ĭ���ǰ�����Ȼ�����ɸߵ��ͣ�a-z����0-���
* ���ǿ����ṩ�Լ���Comparator���޸�������㷨
*
* */

import java.util.*;


public class PriorityQueueTest
{
    public static void main(String[] args) {
        Queue<String> q1 = new PriorityQueue<>();
        q1.offer("sss");
        q1.offer("aaa");
        q1.offer("zzz");
        System.out.println(q1);//[aaa,sss,zzz]
        System.out.println(q1.element());

        Queue<Integer> q2 = new PriorityQueue<>();
        Random rand = new Random(47);
        for(int i=0;i<10;i++)
        {
            q2.offer(rand.nextInt(i+10));
        }
        System.out.println(q2);//PriorityQueue��toString������AbstractCollection����д�ģ���һ���������ȼ���ӡ����
        QueueTest.printQ(q2);//�÷������԰������ȼ���ӡ��PriorityQueue��Ԫ��

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        Queue<String> stringPQ = new PriorityQueue<>(strings);//�����ڴ���PriorityQueue��ͬʱ����Collection������г�ʼ��
        QueueTest.printQ(stringPQ);//Ĭ�����ȼ�a-z���ո����ȼ�������ĸ
        //�����ڴ���PriorityQueue����Ƚ���Comparator�Ӷ��޸����ȼ����㷨
        stringPQ = new PriorityQueue<>(strings.size(),Collections.reverseOrder());//��ʼ����������Ƚ���
        stringPQ.addAll(strings);
        QueueTest.printQ(stringPQ);

        Set<String> set = new HashSet<>(strings);//ͨ��setȥ���ظ�����ĸ
        var stringSetPQ = new PriorityQueue<String>(set);
        QueueTest.printQ(stringSetPQ);

    }
}
