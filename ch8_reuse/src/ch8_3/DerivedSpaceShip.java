package ch8_3;
//ʹ�ü̳д����ɴ���ᱩ¶�����������еĴ��룬��check_itself��ϣ�����������
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
        sp.check_itself();//��ϣ������
    }
}
