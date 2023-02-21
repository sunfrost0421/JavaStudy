package ch10_9;

class A
{
    private interface D{
        void f();
    }
    private class DImp implements D
    {
        @Override
        public void f() {}
    }
    public class DImp2 implements D
    {
        @Override
        public void f() {}
    }
    public D getD(){
        return new DImp2();
    }

}
interface E
{
    interface G{
        void f();
    }
    interface H{
        void f();
    }
    void g();

}
class EImp implements E{
    @Override
    public void g() {}
}
class EGImp implements E.G{
    @Override
    public void f() {}
}
public class NestingInterfaces
{

    public static void main(String[] args) {
        A a = new A();
        EImp eimp = new EImp();
        eimp.g();

        //A.DImp2 di2 = a.getD();
    }
}
