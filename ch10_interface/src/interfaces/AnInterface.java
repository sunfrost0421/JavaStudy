package interfaces;

public interface AnInterface
{
    void firstMethod();
    void SecondMethod();

    default void newMethod() {
        System.out.println("new");
    }
}


