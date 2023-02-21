package ch8_3;
//��ί�е����ģʽ��д��ί�и��ֶ�controls������ѡ����Ҫԭ����������Щ����
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
