package ch13_6;

import java.util.function.IntSupplier;

public class Closure2 {
    IntSupplier makeFun(int x){
        int i = 0;//x和i都是局部变量
        return ()->x+i;//被lambda引用的Lambda以外的局部变量必须是”final型“或者是”实际上的final型“
        //return ()->x+i++;//报错
        //return ()->x+i++;//报错
    }
}
