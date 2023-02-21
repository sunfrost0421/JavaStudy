package stream4End;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* 流的终结操作可以接受一个流，生成一个最终结果，并且不会再把任何东西发给后端流
* 1.转化为数组：Stream.toArray()
* 2.在每个元素上面运行终结操作：
*       Stream.forEach(Consumer):
*       Stream.forEachOrdered(Consumer):确保对元素的操作顺序是原始流的顺序
*   Stream.parallel()是指让多个处理器并行处理流，这个时候可能会出现处理顺序不一致的情况，使用Stream.forEachOrdered(Consumer)
*   可以确保对元素的操作顺序是原始流的顺序
* 3.将流中的元素收集到一个新的对象中：
*       Stream.collect(Collector):常用
*       Stream.collect(Supplier,BiConsumer,BiConsumer):不常用
*   例如:collect.(Collectors.joining(" "));可以将流中各元素以空格间隔组合成一个String
*       collect.(Collectors.toCollection(Tree::new));可以将流中各元素存入treeSet中
*       collect.(Collectors.toMap(key,value));可以将流中的元素存入map中
* 4.组合所有的流元素
*       Stream.reduce(BinaryOperator):传入一个方法，方法有两个T类型形参，一个T类型的返回值。这个方法会对流的每一个元素遍历运行
*       Stream.reduce(identity,BinaryOperator):设定一个初始值。同上
*       第一个方法由于没有初始值，可能值为空，所以返回一个Optional对象
*       第二个方法返回的对象和初始值的类型一致
* 5.匹配
*       allMatch(Predicate):对流中所有元素进行Predicate判断，都返回ture则返回ture否则立即终止判断返回false。与门，都为ture 结果才为true
*       anyMatch(Predicate):对流中所有元素进行Predicate判断，只要有一个为true则立刻终止返回true。或门，存在ture 结果就为true
*       noneMatch(Predicate):对流中所有元素进行Predicate判断，没有true则返回true，否则立刻终止返回false。
* 6.选择
*       findFirst()\findAny
* 7.获得流的相关信息
*       count()\max()\min()....
*
* */
public class StreamEnd
{
    public static void main(String[] args) throws IOException {
        System.out.println("==== forEach ====");
        RandInts.rands().limit(14).forEach(s->System.out.print(s+" "));
        System.out.println();
        RandInts.rands().limit(14).parallel().forEach(s->System.out.print(s+" "));
        System.out.println();
        RandInts.rands().limit(14).parallel().forEachOrdered(s->System.out.print(s+" "));


        System.out.println("\n==== reduce ====");
        //Stream.reduce(identity,BinaryOperator)   identity == 100,BinaryOperator == (sum, item) -> sum + item
        //首先将reduce第一个参数值，赋值给方法的第一个参数，即100->sum
        //方法的第二个参数依次从流的第一个元素遍历到最后一个元素。方法的返回值在每次遍历后赋值给方法的第一个参数sum
        System.out.println("给定个初始值，求和:");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
        //Stream.reduce(BinaryOperator)    BinaryOperator == (sum, item) -> sum + item
        //相当于初始值为流的第一个元素，方法第二个参数从流的第二个元素开始遍历
        //sum == 1,item == 2,每次返回值传给方法的第一个参数也就是sum
        System.out.println("无初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce((sum, item) -> sum + item).orElse(0));
        //找到流中第一个大于4的数
        System.out.println("找到流中第一个大于4的数");
        System.out.println(Stream.of(2,3,4,5,4,6,2).reduce((m,n) -> m>4 ? m:n).get());

        System.out.println("==== Match ====");
        System.out.println(Stream.of(2,3,4,5,4,6,2).peek(x->System.out.println(x+" ")).allMatch(x->x<5));

        System.out.println("==== minmax ====");
        System.out.println("最小单词："+
                Files.lines(Paths.get("Cheese.dat"))
                        .skip(1)
                        .flatMap(s->Arrays.stream(s.split("[ .?,]+")))
                        .peek(System.out::println)
                        .min(String.CASE_INSENSITIVE_ORDER)
                );




    }
}

class RandInts
{
    private static int[] rints = new Random(47)
            .ints(0,1000).limit(100).toArray();
    public static IntStream rands()
    {
        return Arrays.stream(rints);
    }
}
