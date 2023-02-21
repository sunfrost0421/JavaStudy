package ch11_5;

public class Parcel5
{
    //局部内部类
    public Destination destination(String ss)
    {
        final class PDestination implements Destination
        {
            private String label;
            public PDestination(String s)
            {
                label = s;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(ss);
    }

    public Destination destination2(final String ss)
    {
        return new Destination(){
            private String label = ss;
            @Override
            public String readLabel()
            {
                return label;
            }
        };
    }

    public Contents contents()
    {
        return new Contents() {
            private int i = 11;
            @Override
            public int Value() {
                return i;
            }
        };
    }

    public static void main(String[] args)
    {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("shanghai");
        System.out.println(d.readLabel());
    }
}
