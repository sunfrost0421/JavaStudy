package ch13_6;

import java.util.function.IntSupplier;

public class Closure2 {
    IntSupplier makeFun(int x){
        int i = 0;//x��i���Ǿֲ�����
        return ()->x+i;//��lambda���õ�Lambda����ľֲ����������ǡ�final�͡������ǡ�ʵ���ϵ�final�͡�
        //return ()->x+i++;//����
        //return ()->x+i++;//����
    }
}
