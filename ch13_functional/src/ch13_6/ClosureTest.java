package ch13_6;

public class ClosureTest {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        System.out.println(c1.makeFun(0).getAsInt());
        System.out.println(c1.makeFun(0).getAsInt());
        System.out.println(c1.makeFun(0).getAsInt());
    }
}
