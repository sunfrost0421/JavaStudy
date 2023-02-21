package collectionTest.Set;

import java.util.TreeSet;
/*
* 树集
* 1.要使用树集，必须有能够比较的元素，这就要求构造树集的类必须实现Comparable接口，或者在构造集的时候提供一个Comparator
* 2.使用的是红黑树算法来进行排序，每添加一个元素，都会按顺序放在相应的位置上，迭代器按位置访问这些值
*
* */

public class TreeSetTest
{
    public static void main(String[] args)
    {
        var sorter = new TreeSet<String>();//String类实现了Comparable接口
        sorter.add("DDD");
        sorter.add("CCC");
        sorter.add("QQQ");
        for(String s:sorter)
        {
            System.out.println(s);
        }
        //对于自定义的类，可以在类中实现Comparable接口，或者构造树集时在参数中加入Comparator构造器并重现里面的compare方法

    }
}
