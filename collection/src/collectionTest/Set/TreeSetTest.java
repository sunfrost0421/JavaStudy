package collectionTest.Set;

import java.util.TreeSet;
/*
* ����
* 1.Ҫʹ���������������ܹ��Ƚϵ�Ԫ�أ����Ҫ���������������ʵ��Comparable�ӿڣ������ڹ��켯��ʱ���ṩһ��Comparator
* 2.ʹ�õ��Ǻ�����㷨����������ÿ���һ��Ԫ�أ����ᰴ˳�������Ӧ��λ���ϣ���������λ�÷�����Щֵ
*
* */

public class TreeSetTest
{
    public static void main(String[] args)
    {
        var sorter = new TreeSet<String>();//String��ʵ����Comparable�ӿ�
        sorter.add("DDD");
        sorter.add("CCC");
        sorter.add("QQQ");
        for(String s:sorter)
        {
            System.out.println(s);
        }
        //�����Զ�����࣬����������ʵ��Comparable�ӿڣ����߹�������ʱ�ڲ����м���Comparator�����������������compare����

    }
}
