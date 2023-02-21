package Stream2Change;

/*流的中间操作：
* 0.跳过前n个元素：skip(n)
* 1.跟踪和调试：peek(Consumer)
* 2.排序：sorted()。也可以传入一个比较器sort(Comparator.reverseOrder())
* 3.移除元素：（1）distinct():移除流中重复的元素
*           （2）filter(Predicate):只保留流中Predicate的结果为true的元素
* 4.将函数应用于每一个元素：（1）map(Function)返回一个由元素流组成的流,如果返回的值是基本类型，有mapToInt(Function)
*                      （2）flatMap().如果流中含有流类型的元素，则对这个流类型扁平化处理，将其展开为元素
* 5.IntStream.boxed():将基本类型流包装为对象类型流:IntStream ---> Stream<Integer>
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
