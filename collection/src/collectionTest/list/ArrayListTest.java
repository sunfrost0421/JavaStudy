package collectionTest.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListTest
{
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();//创建集合对象
        c.add("hello");
        c.add("world");
        c.add("java");
        System.out.println(c);
        c.remove("hello");//删除集合中特定的元素
        System.out.println(c);
        System.out.println(c.size());//集合的长度
        System.out.println(c.contains("java"));//集合是否包含某个特定元素
        c.clear();//清空集合中所有的元素
        System.out.println(c.isEmpty());//集合是否为空集
        c.add("hello");
        c.add("world");
        c.add("java");
        //c.iterator()返回集合C的迭代器Iterator<E>，it为迭代器接口类型变量
        /*ArrayList中的重写的iterator()方法为
        public Iterator<E> iterator()
        {
            return new Itr();
        }
        private class Itr implements Iterator<E>{...}
        Itr（）为ArrayList的内部类，重写了next，hasNext等方法
        所以c.iterator()返回的是Itr()对象，该对象用接口变量来引用（接口变量引用实现了该接口的类的对象）
        * */
        Iterator<String> it = c.iterator();
        /*迭代器循环遍历元素,我们常用的foreach语句就会被编译器转换为一个迭代器循环*/
        while(it.hasNext())
        {
            System.out.println(it.next()+"   "+it.hasNext());
        }
        it.remove();//该方法只能在it.next()之后使用，删除上一个it.next()返回的元素
        System.out.println(c);
    }
}
