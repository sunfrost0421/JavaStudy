package streams;

import java.util.stream.Stream;

public class Fibonacci
{
    //����һ��쳲�������
    int x = 1;
    public Stream<Integer> numbers()
    {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }
    public static void main(String[] args)
    {
        new Fibonacci().numbers().limit(10).forEach(System.out::println);

    }
}


