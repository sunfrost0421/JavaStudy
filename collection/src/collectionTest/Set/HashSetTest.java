package collectionTest.Set;

import java.util.HashSet;
import java.util.Iterator;
/*
 * Set：不允许出现重复的对象值的一种集合
 * HashSet针对快速查找做了优化，元素顺序按照哈希函数来排序
 *
 * */
public class HashSetTest
{
    public static void main(String[] args)
    {
        var words = new HashSet<String>();//构造一个散列集，默认桶数为16
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("java");//重复的元素不会再进行存储
        words.contains("hello");
        System.out.println(words);

        Iterator it = words.iterator();//生成迭代器：  |"hello"  "world"  "java"
        //迭代器按照桶的顺序遍历，但元素本身存在桶中是没有次序的
        while(it.hasNext())
        {
            String s = (String) it.next();
            System.out.println(s+"  "+s.hashCode()%16);
        }
    }
}
