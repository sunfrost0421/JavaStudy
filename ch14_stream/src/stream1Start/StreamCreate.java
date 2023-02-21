package stream1Start;

/*
* 创建流的操作：
* 1.随机数创建流:new Random(种子).ints(size,下界，上界),左闭右开
* 2.Stream.of(对象1，对象2，对象3...)
* 3.集合对象.stream()
* 4.IntStream.range(下界，上界)，左闭右开
* 5.Stream.generate(实现了接口Supplier的引用或Lambda表达式)，返回该引用.get()得到的值
* 6.Stream.iterate(种子，方法引用)。首先将种子传递给方法引用，返回的结果添加到流中并且保存下来作为下一次iterate调用的第一个参数。
* 7.Stream.build()返回一个Builder接口引用,该引用类似于List,可以往里面添加元素，最后可以用build()方法返回一个Stream对象
* 8.Arrays.stream(数组)。将一个数组转化为流
* 9.Stream.concat(流1，流2)。将两个流组合成一个新流=流1，流2
* 10.Stream.<?>empty()创建一个空流
* */


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamCreate {
    static int x = 1;
    public static void main(String[] args) {
        //1.随机数创建流:new Random(种子).ints(size,下界，上界)
        new Random(47).ints(3,0,10).forEach(a->{System.out.print(a+" ");});
        //2.Stream.of(对象1，对象2，对象3...)
        Stream.of("aa","bb","cc").forEach(System.out::print);
        //3.集合对象.stream()
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream().forEach(System.out::println);
        //4.IntStream.range(下界，上界)，左闭右开
        IntStream.range(0,10).forEach(System.out::println);
        //5.Stream.generate(实现了接口Supplier的引用或Lambda表达式)，返回该引用.get()得到的值
        Stream.generate(()->1).limit(3).forEach(System.out::println);
        //6.Stream.iterate(种子，方法引用)。首先将种子传递给方法引用，返回的结果添加到流中并且保存下来作为下一次iterate调用的第一个参数。
        Stream.iterate(0,a->{
            int result = x+a;
            x = a;
            return result;
        }).limit(10).forEach(a->System.out.print(a+" "));
        //7.Stream.build()返回一个Builder接口引用,该引用类似于List,可以往里面添加元素，最后可以用build()方法返回一个Stream对象
        Stream.Builder<String> builder = Stream.builder();
        builder.add("aa");
        builder.add("bb");
        builder.add("cc");
        builder.build().forEach(System.out::println);
        //8.Arrays.stream(数组)。将一个数组转化为流
        String[] s = "Not much of a cheese shop really, is it?".split(" ");
        Stream stream1 = Arrays.stream(s);
        //9.Stream.concat(流1，流2)。将两个流组合成一个新流=流1，流2
        Stream.concat(IntStream.range(0,3).boxed(), stream1).forEach(System.out::println);
        //10.Stream.<?>empty()创建一个空流
        Stream stringStream1 = Stream.<String>empty();
        Stream<String> stringStream2 = Stream.empty();
    }
}
