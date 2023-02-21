package ch13_8;

import java.util.function.Function;

public class CurryingAndPartials {
    static String uncurried(String a, String b){
        return a+b;
    }

    public static void main(String[] args) {
        uncurried("aaa","bbb");

        Function<String, Function<String,String>> sum = a->b->a+b;
        String s = sum.apply("aaa").apply("bbb");
        System.out.println(s);
    }
}
