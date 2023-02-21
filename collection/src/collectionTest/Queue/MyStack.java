package collectionTest.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ջ����һ�������·�����push��pop��peek��isEmpty��size
 *
 */


public class MyStack {
    public static void main(String[] args) {
        //JAVA1.0�ķ�������stack���ڼ̳������飬�����кܶ�����ķ�����������ܶ����⡣����������Ѿ�����������
        Stack<String> stack = new Stack<>();
        stack.push("aa");//����aa��ѹ��ջ��������ֵ���ǡ�aa"����
        System.out.println(stack.peek());//�鿴ջ��Ԫ��
        System.out.println(stack.pop());//����ջ��Ԫ�ز��ҷ���
        System.out.println(stack.empty());//ջ�Ƿ��ǿ�ջ
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
    }
}
//��������ϵķ�������ArrayDequeʵ���Լ���ջ
class NewStack<T>{
    private Deque<T> stack = new ArrayDeque<T>();
    public void push(T v){
        stack.push(v);
    }
    public T peek(){
        return stack.peek();
    }
    public T pop(){
        return stack.pop();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
}




