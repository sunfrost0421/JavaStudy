package ch12_14;

import java.util.*;
/*
* 已经有了一个接口Iterable，实现之后就可以按照顺序在for-each语法中遍历
* 但是我们希望实现一个功能：“倒序遍历”，同时可以应用于for-each语法。
* for-each语法是接口Iterable的功能，但是“倒序遍历”不是。所以我们需要创建一个“适配器”，将“倒序遍历”的功能适配到接口Iterable中
* 这种方法也叫“适配器方法”
* 创建一个返回接口Iterable的方法，返回的同时用匿名类重写接口Iterable中的iterator()方法，从而修改迭代顺序
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
                    int current = size() - 1;//这里的size其实是内部类访问外部类（ReversibleArrayList）的方法，而外部类继承了ArrayList，所以是ArrayList.size()
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
        //因为ReversibleArrayList继承了ArrayList，而ArrayList实现了Iterable，所以ral可以使用for-each语法
        for(String s:ral)
        {
            System.out.print(s+" ");
        }
        System.out.println();
        //因为ral.reserved()返回了一个实现了Iterable的对象，所以可以使用for-each语法
        //返回的这个对象中重写了Iterable接口中的iterator方法，这个方法重写了迭代器的顺序
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
