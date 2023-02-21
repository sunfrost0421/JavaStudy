package collectionTest.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 栈里面一般有以下方法：push、pop、peek、isEmpty、size
 *
 */


public class MyStack {
    public static void main(String[] args) {
        //JAVA1.0的废弃的类stack由于继承了数组，所以有很多冗余的方法，会产生很多问题。所以这个类已经几乎不用了
        Stack<String> stack = new Stack<>();
        stack.push("aa");//将“aa”压入栈顶，返回值就是“aa"本身
        System.out.println(stack.peek());//查看栈顶元素
        System.out.println(stack.pop());//弹出栈顶元素并且返回
        System.out.println(stack.empty());//栈是否是空栈
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
    }
}
//可以用组合的方法利用ArrayDeque实现自己的栈
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




