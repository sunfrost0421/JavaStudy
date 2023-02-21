package ch13_5;

import java.util.function.Function;

interface FunSS extends Function<String,String>{}
//函数作为返回类型
public class ProduceFunction {
    static Function<String,String> produce(){
        return s->s.toLowerCase();
    }

    public static void main(String[] args) {
        Function f = produce();
        System.out.println(f.apply("AbbbAAA"));
    }
}

