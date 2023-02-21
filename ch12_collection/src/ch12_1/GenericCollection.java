package ch12_1;
import java.util.*;

class Fruit
{
    private String name;
    public Fruit(String s)
    {
        this.name = s;
    }
}

public class GenericCollection
{
    public static void main(String[] args)
    {
        ArrayList<Fruit> fruits1 = new ArrayList<Fruit>();
        ArrayList<Fruit> fruits2 = new ArrayList<>();
        var fruits3 = new ArrayList<Fruit>();
        var fruits4 = new ArrayList<>();
        fruits1.add(new Fruit("1"));
        fruits2.add(new Fruit("2"));
        fruits3.add(new Fruit("3"));
        fruits4.add(new Fruit("4"));
        System.out.println(fruits4.get(0).getClass());


    }
}
