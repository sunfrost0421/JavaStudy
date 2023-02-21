package collectionTest.Queue;

/*优先级队列：每次拿出的元素都是优先级最高的元素
* 优先级的排序默认是按照自然排序，由高到低（a-z）（0-无穷）
* 但是可以提供自己的Comparator来修改排序的算法
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
        System.out.println(q2);//PriorityQueue的toString（）在AbstractCollection中重写的，不一定按照优先级打印出来
        QueueTest.printQ(q2);//该方法可以按照优先级打印出PriorityQueue的元素

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        Queue<String> stringPQ = new PriorityQueue<>(strings);//可以在创建PriorityQueue的同时加入Collection对象进行初始化
        QueueTest.printQ(stringPQ);//默认优先级a-z，空格优先级高于字母
        //可以在创建PriorityQueue导入比较器Comparator从而修改优先级的算法
        stringPQ = new PriorityQueue<>(strings.size(),Collections.reverseOrder());//初始容量，降序比较器
        stringPQ.addAll(strings);
        QueueTest.printQ(stringPQ);

        Set<String> set = new HashSet<>(strings);//通过set去掉重复的字母
        var stringSetPQ = new PriorityQueue<String>(set);
        QueueTest.printQ(stringSetPQ);

    }
}
