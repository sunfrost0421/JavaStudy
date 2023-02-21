package collectionTest.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList<>();//创建集合对象
        staff.add("aaa");// LinkedList.add()添加元素,在链表尾部添加元素
        staff.add("bbb");
        staff.add("ccc");
        System.out.println(staff);
        Iterator<String> it = staff.iterator();//创建迭代器对象
        it.next();
        it.next();
        it.remove();//删除第二个元素
        System.out.println(staff);
        //想要在链表中间添加元素，需要依赖迭代器的位置。
        //但是Iterator中只有4个方法：hasNext();next();remove();forEachRemaining();没有我们所需要的add方法
        /*Iterator有一个子接口：
        * public interface ListIterator<E>
            extends Iterator<E>
        里面是针对与链表的迭代器，而LinkedList.listIterator()方法可以放回这个迭代器;
        * */
        ListIterator<String> iter = staff.listIterator();
        /*add 在迭代器的位置前（!!!左边）添加元素*/
        iter.next();//aaa|ccc--->”|“表示迭代器的位置
        iter.add("b22");//在迭代器的位置前（左边）添加元素  aaa b22 | ccc
        iter.add("b33");//在迭代器的位置前（左边）添加元素  aaa b22 b33 | ccc
        System.out.println(staff);
        /*previous 向前移动迭代器位置,返回越过的元素*/
        System.out.println(iter.previous());//aaa b22 | b33 ccc
        iter.add("xxx");//aaa b22 xxx | b33 ccc
        System.out.println(iter.previous());//aaa b22 | xxx b33 ccc
        /*remove 删除上一次迭代器越过的元素，如果上一次是next（）则删除迭代器位置左边元素，如果上一次是previous则删除迭代器位置右边元素*/
        iter.remove();//aaa b22 | ccc,不能连续用两次remove
        System.out.println(staff);
        /*set 修改上一次迭代器越过的元素，规则与remove类似*/
        iter.previous();//aaa | b22 ccc
        iter.set("bbb");
        System.out.println(staff);

        /*LinkedList.get（n） 按照位置返回链表的第n+1个元素，但是这样的时间复杂度为O(n),一般不用*/
        System.out.println(staff.get(0));

    }
}