package ch13_6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun(){
        List<Integer> ai = new ArrayList<>();//ÿ�δ���ʱ�������һ��ȫ�µĴ洢�ռ䣬һ��ȫ�µ�ArrayList
        //ai = new ArrayList<>();//��ò�Ҫ�޸����¸�ֵ
        ai.add(1);
        return ()->ai;
    }

    public static void main(String[] args) {

    }
}
