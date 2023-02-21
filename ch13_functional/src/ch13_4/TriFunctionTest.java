package ch13_4;

@FunctionalInterface
interface TriFunction<T,U,V,R>
{
    R apply(T t,U u,V v);
}

public class TriFunctionTest {
    static int f(int a,double b,long c){
        return 99;
    }
    public static void main(String[] args) {
        TriFunction<String,String,String,String> triFunction1 = (a,b,c)->a+b+c+"!!";
        TriFunction<Integer,Double,Long,Integer> triFunction2 = TriFunctionTest::f;
        System.out.println(triFunction1.apply("a","b","c"));
        System.out.println(triFunction2.apply(1,2.0,(long) 2));

    }
}
