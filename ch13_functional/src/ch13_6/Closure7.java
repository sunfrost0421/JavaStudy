package ch13_6;

import java.util.function.IntSupplier;

public class Closure7 {
    IntSupplier makeFun(int x){
        Integer i = 0;//i�Ƕ��󣬵����ְ�װ���������⣬
        i = i+1;
        return ()->x;
        //return ()->x+i;//i����final�ͣ��������˸ı�
    }
}
