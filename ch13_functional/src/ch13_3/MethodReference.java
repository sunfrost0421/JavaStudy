package ch13_3;

interface Callable{
    void call(String s);
}

class Describe{
    void show(String msg)
    {
        System.out.println(msg);
    }
}

public class MethodReference
{
    static void hello(String name)
    {
        System.out.println("hello "+name);
    }
    static class Description{
        String about;
        Description(String desc){
            about = desc;
        }
        void help(String msg)
        {
            System.out.println(about+" "+msg);
        }
    }
    static class Helper{
        static void assist(String msg)
        {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;//1.��ͨ�����ͨ����������ʵ������������
        c.call("call()");
        c = MethodReference::hello;//2.��ͨ��ľ�̬��������������������
        c.call("Bob");
        c = new Description("valuable")::help;//3-1.��̬�ڲ������ͨ����,new ������������������"�󶨷�������"
        c.call("information");
        Description d2 = new Description("valuable");//3-2.��̬�ڲ������ͨ����������ʵ������������
        c = d2::help;
        c.call("information");
        c = Helper::assist;//4.��̬�ڲ���ľ�̬��������������������
        c.call("Help");
    }
}
