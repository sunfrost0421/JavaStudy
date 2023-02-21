package ch12_14;

import java.util.*;
/*
* �Ѿ�����һ���ӿ�Iterable��ʵ��֮��Ϳ��԰���˳����for-each�﷨�б���
* ��������ϣ��ʵ��һ�����ܣ��������������ͬʱ����Ӧ����for-each�﷨��
* for-each�﷨�ǽӿ�Iterable�Ĺ��ܣ����ǡ�������������ǡ�����������Ҫ����һ����������������������������Ĺ������䵽�ӿ�Iterable��
* ���ַ���Ҳ�С�������������
* ����һ�����ؽӿ�Iterable�ķ��������ص�ͬʱ����������д�ӿ�Iterable�е�iterator()�������Ӷ��޸ĵ���˳��
* */

class ReversibleArrayList<T> extends ArrayList<T>
{
    ReversibleArrayList(Collection<T> c)
    {
        super(c);
    }

    public Iterable<T> reserved()
    {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator(){
                return new Iterator<T>() {
                    int current = size() - 1;//�����size��ʵ���ڲ�������ⲿ�ࣨReversibleArrayList���ķ��������ⲿ��̳���ArrayList��������ArrayList.size()
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}

class RandomArrayList<T> extends ArrayList<T>
{
    private List<T> words;
    public RandomArrayList(List<T> c)
    {
        super(c);
        words = c;
    }

    public Iterable<T> randomized()
    {
        return new Iterable<T>()
        {
            @Override
            public Iterator<T> iterator() {
                Collections.shuffle(words, new Random(47));
                return words.iterator();
            }
        };
    }
}


public class AdapterMethodIdiom
{
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        //��ΪReversibleArrayList�̳���ArrayList����ArrayListʵ����Iterable������ral����ʹ��for-each�﷨
        for(String s:ral)
        {
            System.out.print(s+" ");
        }
        System.out.println();
        //��Ϊral.reserved()������һ��ʵ����Iterable�Ķ������Կ���ʹ��for-each�﷨
        //���ص������������д��Iterable�ӿ��е�iterator���������������д�˵�������˳��
        for(String s:ral.reserved())
        {
            System.out.print(s+" ");
        }
        System.out.println();
        RandomArrayList<String> ral2 = new RandomArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        for(String s:ral2.randomized())
        {
            System.out.print(s+" ");
        }


    }
}
