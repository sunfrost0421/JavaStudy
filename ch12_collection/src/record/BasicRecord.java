package record;

/*
* Java JDK16�����ԣ�
* record�ؼ��֣�������class����һ���࣬���Ǳ��������Զ�Ϊ��������ɣ�
* 1.���ɱ��˽���ֶ�
* 2.һ���淶�Ĺ�����
* 3.�����ֶεķ��������������ֶ������
* 4.equals()
* 5.hashCode()
* 6.toString()
* ע�⣺
* ������record������ֶ�
* ������ӷ��������������ֶ�Ĭ��Ϊfinal�ģ�������ӵķ���ֻ�ܶ�ȡ�ֶΣ������޸��ֶ�
* record���ܼ̳������࣬������Ҳ���ܼ̳�record
* record����ʵ�ֽӿ�
* record������Ϊ�ڲ��࣬��ʱĬ��Ϊstatic����
* ����д����չ��������൱����Ĭ�ϵı�׼������������ӷ������ֹ�������ʽΪ������{}���������治�Ӳ����б���
* �����Լ�д�����������ʱ�򣬹������Ĳ����б���record�Ĳ����б����һģһ�����������п��Զ��ֶν����״γ�ʼ���������ֶθ�ֵ
* */

import java.util.Map;

record Employee(String name, int id){}
record Point(int x, int y){
    void mustPositive(int v)
    {
        if(v<0)
        {
            System.out.println(v+"<0,v should be change");
        }
    }
    //���չ�����
    Point
    {
        mustPositive(x);
        mustPositive(y);
    }
}
record Value(int x)
{
    //��ͨ������
    Value(int x){
        this.x = x+10;
    }
}

public class BasicRecord
{
    public static void main(String[] args) {
        var p1 = new Employee("qrc",1);
        Employee p2 = new Employee("hjx",2);
        System.out.println(p1.name()+":"+p1.id());
        System.out.println(p2.name()+":"+p2.id());
        System.out.println(p1);
        var map = Map.of(p1,"nanjing",p2,"shanghai");
        System.out.println(map);
        var p3 = new Employee(p1.name(), p1.id());
        System.out.println(p3.equals(p1));


        var v1 = new Value(1);
        System.out.println(v1);

    }
}
