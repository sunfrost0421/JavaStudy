package ch11_7;

class MNA
{
    private void f(){}
    public void ff(){}
    class A
    {
        private void g(){}
        class B
        {
            void h()
            {
                f();
                g();
            }
        }
    }
    static class D
    {
        //f();
    }
}

interface Inter {
    void aaa();
}
class X implements Inter
{
    @Override
    public void aaa() {

    }
    class Y
    {
        private void bbb()
        {
            aaa();
        }
    }
}

public class MultiNestingAccess
{


}
