package collectionTest.Set;

import java.util.HashSet;
import java.util.Iterator;
/*
 * Set������������ظ��Ķ���ֵ��һ�ּ���
 * HashSet��Կ��ٲ��������Ż���Ԫ��˳���չ�ϣ����������
 *
 * */
public class HashSetTest
{
    public static void main(String[] args)
    {
        var words = new HashSet<String>();//����һ��ɢ�м���Ĭ��Ͱ��Ϊ16
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("java");//�ظ���Ԫ�ز����ٽ��д洢
        words.contains("hello");
        System.out.println(words);

        Iterator it = words.iterator();//���ɵ�������  |"hello"  "world"  "java"
        //����������Ͱ��˳���������Ԫ�ر������Ͱ����û�д����
        while(it.hasNext())
        {
            String s = (String) it.next();
            System.out.println(s+"  "+s.hashCode()%16);
        }
    }
}
