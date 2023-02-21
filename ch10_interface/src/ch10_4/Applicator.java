package ch10_4;


public class Applicator
{
    //策略设计模式：根据传递参数的对象来表现出不同的行为
    public static void apply(Processor p,Object o)
    {
        System.out.println(p.name());
        System.out.println(p.process(o));
    }
    public static void main(String[] args) {
        String s = "How Are You";
        apply(new UpCase(), s);
        apply(new DownCase(), s);

    }

}

class Processor
{
    public String name()
    {
        return getClass().getSimpleName();
    }
    public Object process(Object input)
    {
        return input;
    }
}
class UpCase extends Processor
{
    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class DownCase extends Processor
{
    @Override
    public Object process(Object input)
    {
        return ((String)input).toLowerCase();
    }
}
