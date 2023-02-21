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
        Callable c = d::show;//1.普通类的普通方法，对象实例：：方法名
        c.call("call()");
        c = MethodReference::hello;//2.普通类的静态方法，类名：：方法名
        c.call("Bob");
        c = new Description("valuable")::help;//3-1.静态内部类的普通方法,new 构造器：：方法名，"绑定方法引用"
        c.call("information");
        Description d2 = new Description("valuable");//3-2.静态内部类的普通方法，对象实例：：方法名
        c = d2::help;
        c.call("information");
        c = Helper::assist;//4.静态内部类的静态方法，类名：：方法名
        c.call("Help");
    }
}
