package stream1Start;

/*
* �������Ĳ�����
* 1.�����������:new Random(����).ints(size,�½磬�Ͻ�),����ҿ�
* 2.Stream.of(����1������2������3...)
* 3.���϶���.stream()
* 4.IntStream.range(�½磬�Ͻ�)������ҿ�
* 5.Stream.generate(ʵ���˽ӿ�Supplier�����û�Lambda���ʽ)�����ظ�����.get()�õ���ֵ
* 6.Stream.iterate(���ӣ���������)�����Ƚ����Ӵ��ݸ��������ã����صĽ����ӵ����в��ұ���������Ϊ��һ��iterate���õĵ�һ��������
* 7.Stream.build()����һ��Builder�ӿ�����,������������List,�������������Ԫ�أ���������build()��������һ��Stream����
* 8.Arrays.stream(����)����һ������ת��Ϊ��
* 9.Stream.concat(��1����2)������������ϳ�һ������=��1����2
* 10.Stream.<?>empty()����һ������
* */


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamCreate {
    static int x = 1;
    public static void main(String[] args) {
        //1.�����������:new Random(����).ints(size,�½磬�Ͻ�)
        new Random(47).ints(3,0,10).forEach(a->{System.out.print(a+" ");});
        //2.Stream.of(����1������2������3...)
        Stream.of("aa","bb","cc").forEach(System.out::print);
        //3.���϶���.stream()
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream().forEach(System.out::println);
        //4.IntStream.range(�½磬�Ͻ�)������ҿ�
        IntStream.range(0,10).forEach(System.out::println);
        //5.Stream.generate(ʵ���˽ӿ�Supplier�����û�Lambda���ʽ)�����ظ�����.get()�õ���ֵ
        Stream.generate(()->1).limit(3).forEach(System.out::println);
        //6.Stream.iterate(���ӣ���������)�����Ƚ����Ӵ��ݸ��������ã����صĽ����ӵ����в��ұ���������Ϊ��һ��iterate���õĵ�һ��������
        Stream.iterate(0,a->{
            int result = x+a;
            x = a;
            return result;
        }).limit(10).forEach(a->System.out.print(a+" "));
        //7.Stream.build()����һ��Builder�ӿ�����,������������List,�������������Ԫ�أ���������build()��������һ��Stream����
        Stream.Builder<String> builder = Stream.builder();
        builder.add("aa");
        builder.add("bb");
        builder.add("cc");
        builder.build().forEach(System.out::println);
        //8.Arrays.stream(����)����һ������ת��Ϊ��
        String[] s = "Not much of a cheese shop really, is it?".split(" ");
        Stream stream1 = Arrays.stream(s);
        //9.Stream.concat(��1����2)������������ϳ�һ������=��1����2
        Stream.concat(IntStream.range(0,3).boxed(), stream1).forEach(System.out::println);
        //10.Stream.<?>empty()����һ������
        Stream stringStream1 = Stream.<String>empty();
        Stream<String> stringStream2 = Stream.empty();
    }
}
