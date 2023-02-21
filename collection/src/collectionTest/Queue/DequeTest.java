package collectionTest.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现了Deque的类有两种：LinkedList、ArrayDeque
 * 它的两端都可以实现进出的功能，使用起来十分灵活
 *                   Last                   First
 *                   -------------------(<-入栈push)
 * 入队offer/add==> （队尾）e a b c d（队头/栈顶）          ==>出队poll/remove
 *                   -------------------(->出栈pop)
 *   <==从队尾出pollLast/removeLast
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
