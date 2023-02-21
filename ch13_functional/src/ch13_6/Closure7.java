package ch13_6;

import java.util.function.IntSupplier;

public class Closure7 {
    IntSupplier makeFun(int x){
        Integer i = 0;//i是对象，但这种包装器对象特殊，
        i = i+1;
        return ()->x;
        //return ()->x+i;//i不是final型，它发生了改变
    }
}
