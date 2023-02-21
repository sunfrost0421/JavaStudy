package record;

/*
* Java JDK16新特性：
* record关键字，类似于class创建一个类，但是编译器会自动为这个类生成：
* 1.不可变的私有字段
* 2.一个规范的构造器
* 3.访问字段的方法，方法名与字段名相等
* 4.equals()
* 5.hashCode()
* 6.toString()
* 注意：
* 不能向record中添加字段
* 可以添加方法，但是由于字段默认为final的，所以添加的方法只能读取字段，不能修改字段
* record不能继承其他类，其他类也不能继承record
* record可以实现接口
* record可以作为内部类，此时默认为static类型
* 可以写入紧凑构造器，相当于在默认的标准构造器后面添加方法这种构造器格式为：类名{}。类名后面不加参数列表（）
* 可以自己写构造器，这个时候，构造器的参数列表与record的参数列表必须一模一样。构造器中可以对字段进行首次初始化，即对字段赋值
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
    //紧凑构造器
    Point
    {
        mustPositive(x);
        mustPositive(y);
    }
}
record Value(int x)
{
    //普通构造器
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
