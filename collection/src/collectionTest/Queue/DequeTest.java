package collectionTest.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ʵ����Deque���������֣�LinkedList��ArrayDeque
 * �������˶�����ʵ�ֽ����Ĺ��ܣ�ʹ������ʮ�����
 *                   Last                   First
 *                   -------------------(<-��ջpush)
 * ���offer/add==> ����β��e a b c d����ͷ/ջ����          ==>����poll/remove
 *                   -------------------(->��ջpop)
 *   <==�Ӷ�β��pollLast/removeLast
 *
 * */
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");
        deque.add("e");
        System.out.println(deque.poll());
        System.out.println(deque.peek());
        System.out.println(deque.peekLast());

    }
}
