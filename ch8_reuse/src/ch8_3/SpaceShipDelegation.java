package ch8_3;
//用委托的设计模式来写，委托给字段controls。可以选中需要原控制器的哪些方法
public class SpaceShipDelegation
{
    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name)
    {
        this.name = name;
    }
    void up(int v) {
        controls.up(v);
    }

    void down(int v) {
        controls.down(v);
    }

    void left(int v) {
        controls.left(v);
    }

    void right(int v) {
        controls.right(v);
    }
}
