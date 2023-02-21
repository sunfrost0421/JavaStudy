package ch11_3;


public class DotThis
{
    void f()
    {
        System.out.println("DotThis.f()");
    }
    public class Inner
    {
        //在内部类中编写返回外部类的方法
        public DotThis outer()
        {
            return DotThis.this;
        }
    }
    //在外部类中编写返回内部类的方法
    public Inner inner()
    {
        return new Inner();
    }
}
class Test
{
    public static void main(String[] args)
    {

        DotThis dot = new DotThis();
        //  DotThis.Inner inDot = new DotThis.Inner();//不能直接这样写
        DotThis.Inner inDot = dot.new Inner();
        DotThis.Inner inDot2 = dot.inner();
        //DotThis dot_in = dot.inner();//内部类不能转型为外部类
    }
}