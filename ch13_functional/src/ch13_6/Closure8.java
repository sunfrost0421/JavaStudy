package ch13_6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun(){
        List<Integer> ai = new ArrayList<>();//每次创建时都会分配一个全新的存储空间，一个全新的ArrayList
        //ai = new ArrayList<>();//最好不要修改重新赋值
        ai.add(1);
        return ()->ai;
    }

    public static void main(String[] args) {

    }
}
