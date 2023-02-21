package ch13_5;

import java.util.function.Function;

class I{}
class O{}

public class TransformFunction
{
    static Function<I,O> transform(Function<I,O> in){
        return in.andThen(o->{
            System.out.println("o");
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I,O> f = transform(i->{
            System.out.println("i");
            return new O();
        });
        f.apply(new I());
    }
}
