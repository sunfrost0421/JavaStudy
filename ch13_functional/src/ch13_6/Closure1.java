package ch13_6;

import java.util.function.IntSupplier;

public class Closure1 {
    int i = 0;//iΪȫ�ֱ���
    IntSupplier makeFun(int x)
    {
        return ()->x+i++;
    }
}
