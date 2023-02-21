package stream4End;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* �����ս�������Խ���һ����������һ�����ս�������Ҳ����ٰ��κζ������������
* 1.ת��Ϊ���飺Stream.toArray()
* 2.��ÿ��Ԫ�����������ս������
*       Stream.forEach(Consumer):
*       Stream.forEachOrdered(Consumer):ȷ����Ԫ�صĲ���˳����ԭʼ����˳��
*   Stream.parallel()��ָ�ö�����������д����������ʱ����ܻ���ִ���˳��һ�µ������ʹ��Stream.forEachOrdered(Consumer)
*   ����ȷ����Ԫ�صĲ���˳����ԭʼ����˳��
* 3.�����е�Ԫ���ռ���һ���µĶ����У�
*       Stream.collect(Collector):����
*       Stream.collect(Supplier,BiConsumer,BiConsumer):������
*   ����:collect.(Collectors.joining(" "));���Խ����и�Ԫ���Կո�����ϳ�һ��String
*       collect.(Collectors.toCollection(Tree::new));���Խ����и�Ԫ�ش���treeSet��
*       collect.(Collectors.toMap(key,value));���Խ����е�Ԫ�ش���map��
* 4.������е���Ԫ��
*       Stream.reduce(BinaryOperator):����һ������������������T�����βΣ�һ��T���͵ķ���ֵ����������������ÿһ��Ԫ�ر�������
*       Stream.reduce(identity,BinaryOperator):�趨һ����ʼֵ��ͬ��
*       ��һ����������û�г�ʼֵ������ֵΪ�գ����Է���һ��Optional����
*       �ڶ����������صĶ���ͳ�ʼֵ������һ��
* 5.ƥ��
*       allMatch(Predicate):����������Ԫ�ؽ���Predicate�жϣ�������ture�򷵻�ture����������ֹ�жϷ���false�����ţ���Ϊture �����Ϊtrue
*       anyMatch(Predicate):����������Ԫ�ؽ���Predicate�жϣ�ֻҪ��һ��Ϊtrue��������ֹ����true�����ţ�����ture �����Ϊtrue
*       noneMatch(Predicate):����������Ԫ�ؽ���Predicate�жϣ�û��true�򷵻�true������������ֹ����false��
* 6.ѡ��
*       findFirst()\findAny
* 7.������������Ϣ
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
        //���Ƚ�reduce��һ������ֵ����ֵ�������ĵ�һ����������100->sum
        //�����ĵڶ����������δ����ĵ�һ��Ԫ�ر��������һ��Ԫ�ء������ķ���ֵ��ÿ�α�����ֵ�������ĵ�һ������sum
        System.out.println("��������ʼֵ�����:");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
        //Stream.reduce(BinaryOperator)    BinaryOperator == (sum, item) -> sum + item
        //�൱�ڳ�ʼֵΪ���ĵ�һ��Ԫ�أ������ڶ������������ĵڶ���Ԫ�ؿ�ʼ����
        //sum == 1,item == 2,ÿ�η���ֵ���������ĵ�һ������Ҳ����sum
        System.out.println("�޳�ʼֵ�����");
        System.out.println(Stream.of(1, 2, 3, 4).reduce((sum, item) -> sum + item).orElse(0));
        //�ҵ����е�һ������4����
        System.out.println("�ҵ����е�һ������4����");
        System.out.println(Stream.of(2,3,4,5,4,6,2).reduce((m,n) -> m>4 ? m:n).get());

        System.out.println("==== Match ====");
        System.out.println(Stream.of(2,3,4,5,4,6,2).peek(x->System.out.println(x+" ")).allMatch(x->x<5));

        System.out.println("==== minmax ====");
        System.out.println("��С���ʣ�"+
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
