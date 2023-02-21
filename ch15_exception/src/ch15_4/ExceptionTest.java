package ch15_4;

class MyException1 extends Exception{}
class MyException2 extends Exception{
    public MyException2(){};
    public MyException2(String s){
        super(s);
    }
}

public class ExceptionTest{
    public void f() throws MyException1{
        System.out.println("Throw MyException1 from f()");
        throw new MyException1();
    }
    public void g() throws MyException2{
        System.out.println("Throw MyException2 from g()");
        throw new MyException2("Originated in g()");
    }
    public static void main(String[] args) {
        ExceptionTest sed = new ExceptionTest();
        try{
            sed.f();
        }catch (MyException1 e){
            e.printStackTrace();//打印到标准错误流，相当于e.printStackTrace(System.err);
        }
        try{
            sed.g();
        }catch (MyException2 e){
            e.printStackTrace(System.out);//打印到标准输出流
        }

    }
}
