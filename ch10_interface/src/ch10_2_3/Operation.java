package ch10_2_3;

public interface Operation
{
    void execute();
    static void ranOps(Operation... ops)
    {
        for(Operation op:ops)
            op.execute();
    }
    static void show(String msg)
    {
        System.out.println(msg);
    }
}
