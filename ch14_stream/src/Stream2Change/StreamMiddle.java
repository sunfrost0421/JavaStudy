package Stream2Change;

/*�����м������
* 0.����ǰn��Ԫ�أ�skip(n)
* 1.���ٺ͵��ԣ�peek(Consumer)
* 2.����sorted()��Ҳ���Դ���һ���Ƚ���sort(Comparator.reverseOrder())
* 3.�Ƴ�Ԫ�أ���1��distinct():�Ƴ������ظ���Ԫ��
*           ��2��filter(Predicate):ֻ��������Predicate�Ľ��Ϊtrue��Ԫ��
* 4.������Ӧ����ÿһ��Ԫ�أ���1��map(Function)����һ����Ԫ������ɵ���,������ص�ֵ�ǻ������ͣ���mapToInt(Function)
*                      ��2��flatMap().������к��������͵�Ԫ�أ������������ͱ�ƽ����������չ��ΪԪ��
* 5.IntStream.boxed():��������������װΪ����������:IntStream ---> Stream<Integer>
*
*HashSet<Integer> set = new HashSet<>();
*
* */

import java.util.Arrays;

public class StreamMiddle {
    public static void main(String[] args) {
        String[] s = "Not much of a cheese shop really, is it?".split(" ");
        Arrays.stream(s).skip(3).peek(w->System.out.print("peek1:("+w+")"))
                .map(w->w+" ")
                .peek(w->System.out.print("peek2:("+w+")"))
                .map(String::toUpperCase)
                .sorted()
                .peek(w->System.out.print("peek3:("+w+")"))
                .forEach(System.out::println);
    }
}
