package collectionTest.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListTest
{
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();//�������϶���
        c.add("hello");
        c.add("world");
        c.add("java");
        System.out.println(c);
        c.remove("hello");//ɾ���������ض���Ԫ��
        System.out.println(c);
        System.out.println(c.size());//���ϵĳ���
        System.out.println(c.contains("java"));//�����Ƿ����ĳ���ض�Ԫ��
        c.clear();//��ռ��������е�Ԫ��
        System.out.println(c.isEmpty());//�����Ƿ�Ϊ�ռ�
        c.add("hello");
        c.add("world");
        c.add("java");
        //c.iterator()���ؼ���C�ĵ�����Iterator<E>��itΪ�������ӿ����ͱ���
        /*ArrayList�е���д��iterator()����Ϊ
        public Iterator<E> iterator()
        {
            return new Itr();
        }
        private class Itr implements Iterator<E>{...}
        Itr����ΪArrayList���ڲ��࣬��д��next��hasNext�ȷ���
        ����c.iterator()���ص���Itr()���󣬸ö����ýӿڱ��������ã��ӿڱ�������ʵ���˸ýӿڵ���Ķ���
        * */
        Iterator<String> it = c.iterator();
        /*������ѭ������Ԫ��,���ǳ��õ�foreach���ͻᱻ������ת��Ϊһ��������ѭ��*/
        while(it.hasNext())
        {
            System.out.println(it.next()+"   "+it.hasNext());
        }
        it.remove();//�÷���ֻ����it.next()֮��ʹ�ã�ɾ����һ��it.next()���ص�Ԫ��
        System.out.println(c);
    }
}
