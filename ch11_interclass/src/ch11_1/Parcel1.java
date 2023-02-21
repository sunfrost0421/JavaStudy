package ch11_1;

public class Parcel1
{
    class Contents{
        private int i = 11;
        public int value()
        {
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo)
        {
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }
    public Contents contents()
    {
        return new Contents();
    }
    public Destination to(String s)
    {
        return new Destination(s);
    }
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args)
    {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
        Parcel1 p2 = new Parcel1();
        Parcel1.Contents pc = p2.contents();
        Parcel1.Destination pd = p2.to("Borneo");
    }
}
