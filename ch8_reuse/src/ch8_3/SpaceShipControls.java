package ch8_3;
//这是一个宇宙飞船的控制器,需要建立一个飞船类，能够复用该控制器的前4个方法
public class SpaceShipControls
{
    void up(int v) {}
    void down(int v) {}
    void left(int v) {}
    void right(int v) {}

    void check_itself()
    {
        System.out.println("it is OK");
    }
}
