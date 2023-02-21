package ch11_10;

class Egg2
{
    protected class Yolk{
        Yolk(){
            System.out.println("Egg2.Yolk()");
        }
        public void f(){
            System.out.println("Egg2.Yolk.f()");
        }
    }
    private Yolk yolk = new Yolk();
    Egg2(){
        System.out.println("New Egg2");
    }
    public void insertYolk(Yolk yy)
    {
        yolk = yy;
    }
    public void g()
    {
        yolk.f();
    }
}

public class BigEgg2 extends Egg2
{
    public class Yolk extends Egg2.Yolk
    {
        public Yolk()
        {
            System.out.println("BigEgg2.Yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk().f()");
        }
    }
    public BigEgg2()
    {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}
