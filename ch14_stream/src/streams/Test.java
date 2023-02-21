package streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test
{
    public static void main(String[] args)
    {
        String[] s = {"hello","java","!","i","love","you"};
        //Arrays.stream(s).limit(3).forEach(System.out::println);
        //Arrays.stream(new int[] {1,3,5,7,9},1,4).forEach(n->System.out.format("%d ",n));
        //Arrays.stream(s).peek((w)->System.out.print("("+w+")")).map(w->w+" ").forEach(System.out::print);

        Stream.of(1,2,3)
                .map(i->Stream.of("aaa","bbb","ccc"))
                .forEach(System.out::println);
        Stream.of(1,2,3)
                .flatMap(i->Stream.of("aaa","bbb","ccc"))
                .forEach(System.out::print);
    }
}
