package path;
/**
 * Path对象代表一个文件的目录或者路径，他是在不同的操作系统和文件系统之上的抽象
 * 用了Path之后，我们不用注意底层的操作系统，代码不需要重写就可以在不同的操作系统上面工作
 * 路径不必对应着实际存在的文件。相反，想要创建文件，首先要创建一个路径，然后调用方法创建文件
 * 静态：Paths.get(String/uri)
 * Path.resolve(Path)
 *
 * */
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo
{
    public static void main(String[] args)
    {
        /*Paths.get():将路径字符串或连接为路径字符串时形成的字符串序列转换为路径。*/
        //D:\workpalce\OnJava\ch17_file。对于不同的操作系统分隔符可能不一样
        //所以Paths.get可以将各个路径的名字根据所使用的操作系统组合成一个Path对象
        Path p1 = Paths.get("D:","workplace","OnJava","ch17_file");//绝对路径构建
        System.out.println(p1);
        Path p2 = Paths.get("PathInfo.java");//在当前java文件工作路径(工程文件夹路径)下建立相对路径
        System.out.println(p2);
        System.out.println(p2.toAbsolutePath());
        Path p3 = Paths.get("aaa.txt");//在当前java文件工作路径(工程文件夹路径)下建立相对路径对象，即使文件不存在
        System.out.println(p3);
        System.out.println(p3.toAbsolutePath());

        Path p4 = p2.toAbsolutePath();//得到p2的绝对路径，p4表示的位置与p2一致

        //拆分绝对路径，拆分不显示跟路径D:
        for(int i = 0;i<p4.getNameCount();i++)
        {
            System.out.println(p4.getName(i));
        }
        //endsWith(x)可以判断路径的最后一个组件是不是x
        System.out.println("PathInfo.java绝对路径以PathInfo.java结束吗："+p4.endsWith("PathInfo.java"));
        System.out.println("PathInfo.java绝对路径以.java结束吗："+p4.endsWith(".java"));
        //startsWith(x)可以判断x是否为路径的根为D：\，注意无法通过getName(i)得到根路径
        System.out.println("PathInfo.java绝对路径以workplace开始吗："+p4.startsWith("workpalce"));
        System.out.println("PathInfo.java绝对路径以D:\\开始吗："+p4.startsWith("D:\\"));

        System.out.println(p4.getRoot());
        System.out.println("p4:  "+p4);
//        System.out.println(p4.resolve("ADD"));
//        System.out.println(p4.getParent());//得到上一级路径
        Path p5 = p4.resolveSibling("ADD2");//产生p4的同级路径
        System.out.println("p5:  "+p5);
        System.out.println(p5.getFileName());//返回路径的最后一个部件
        System.out.println(p4.relativize(p5));//p5相对于p4的路径
        System.out.println(p5.relativize(p4));//p4相对于p5的路径
    }
}
