package interfaces;

public class AnImplement implements AnInterface
{
    @Override
    public void firstMethod() {
        System.out.println("first");
    }

    @Override
    public void SecondMethod() {
        System.out.println("second");
    }
    public static void main(String[] args)
    {
        AnInterface i = new AnImplement();
        i.firstMethod();
        i.SecondMethod();
        i.newMethod();
    }
}


