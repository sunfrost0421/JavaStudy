package ch8_3;
//使用继承创建飞船类会暴露控制器中所有的代码，但check_itself不希望在这个类中
public class DerivedSpaceShip extends SpaceShipControls
{
    private String name;
    public DerivedSpaceShip(String name)
    {
        this.name = name;
    }
    public static void main(String[] args)
    {
        DerivedSpaceShip sp = new DerivedSpaceShip("NSEA Protector");
        sp.up(100);
        sp.check_itself();//不希望存在
    }
}
