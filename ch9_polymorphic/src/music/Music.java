package music;

public class Music
{
    static void turn(Instrument i)
    {
        System.out.println(i.what());
    }
    public static void main(String[] args)
    {
        Wind w = new Brass();
        turn(w);
    }
}
enum Note
{
    MIDDLE_C,C_SHARP,B_FLAT;
}
class Instrument
{
    private void play(Note n)
    {
        System.out.println("Instrument.play() = "+n);
    }
    public String what()
    {
        return "Instrument";
    }

    public static void main(String[] args) {
        //由于play在Instrument中为private，所以此方法不是多态的
        Instrument ins = new Percussion();
        ins.play(Note.C_SHARP);
        Percussion p = new Percussion();
        p.play(Note.C_SHARP);
    }

}
class Wind extends Instrument
{

    public void play(Note n) {
        System.out.println("Wind.play() = "+n);
    }

    @Override
    public String what() {
        return "Wind";
    }
}
class Percussion extends Instrument
{
    public void play(Note n) {
        System.out.println("Percussion.play() = "+n);
    }

    @Override
    public String what() {
        return "Percussion";
    }
}
class Brass extends Wind
{

    public void play(Note n) {
        System.out.println("Brass.play() = "+n);
    }

    @Override
    public String what() {
        return "Brass";
    }
}

