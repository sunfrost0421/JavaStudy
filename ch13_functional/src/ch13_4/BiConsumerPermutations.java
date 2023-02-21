package ch13_4;

import java.util.function.BiConsumer;

public class BiConsumerPermutations {
    static BiConsumer<Integer,Double> bicid = (i,d)->System.out.format("%d,%f%n",i,d);

    public static void main(String[] args) {
        bicid.accept(1,2.2);
    }
}
