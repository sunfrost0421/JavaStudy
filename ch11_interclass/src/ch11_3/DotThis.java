package ch11_3;


public class DotThis
{
    void f()
    {
        System.out.println("DotThis.f()");
    }
    public class Inner
    {
        //���ڲ����б�д�����ⲿ��ķ���
        public DotThis outer()
        {
            return DotThis.this;
        }
    }
    //���ⲿ���б�д�����ڲ���ķ���
    public Inner inner()
    {
        return new Inner();
    }
}
class Test
{
    public static void main(String[] args)
    {

        DotThis dot = new DotThis();
        //  DotThis.Inner inDot = new DotThis.Inner();//����ֱ������д
        DotThis.Inner inDot = dot.new Inner();
        DotThis.Inner inDot2 = dot.inner();
        //DotThis dot_in = dot.inner();//�ڲ��಻��ת��Ϊ�ⲿ��
    }
}