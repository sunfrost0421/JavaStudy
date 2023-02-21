package directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/*
* 目录表示的是文件夹
*
* */
public class DirectoryTest
{
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("D:","workplace","OnJava","ch17_file","test1");
        System.out.println(p1);
        //Files.createDirectory(p1);//在指定路径创建文件夹，要求路径除了最后一个部件外，前面都是已经实际存在的
        System.out.println(Files.isDirectory(p1));
        Path p2 = Paths.get("D:","workplace","OnJava","ch17_file","test2","qrc","love","hjx");
        System.out.println("p2:  "+p2);
        //Files.createDirectories(p2);//在指定路径创建文件夹，这个路径可以有很多实际不存在的部件
        Path p3 = p2.resolve("loveYou.txt");
        System.out.println("p3:  "+p3);
        //Files.createFile(p3);//在指定位置创建文件
        Path p4 = p2.getParent().resolve("loveYou.txt");
        System.out.println("p4:  "+p4);
        //Files.copy(p3,p4);//复制文件到指定路径，源文件保留。若指定路径已有文件，则抛异常
        Path p5 = p4.getParent().getParent().resolve("loveYou.txt");
        System.out.println("p5:  "+p5);
        //Files.move(p4,p5);//移动文件到指定路径，源文件删除。若指定路径已有文件，则抛异常
        //若指定路径已有文件，可以添加参数StandardCopyOption.REPLACE_EXISTING，表示覆盖已有文件
        Files.copy(p3,p5,StandardCopyOption.REPLACE_EXISTING);
        Files.delete(p5);//删除文件,若文件不存在，则抛异常。可以采用下面这个办法
        System.out.println(Files.deleteIfExists(p5));//若文件不存在，不操作，返回false
        //Files.delete(p1);//也可以删除目录，也就是文件夹，但只能删除最外层一级的空目录

        System.out.println("Files.list(p2)：");
        Files.list(p2).forEach(System.out::println);// Files.list(p2)将P2路径下所有文件（不包括子目录）组成一个Path流
        System.out.println("Files.walk(p2)：");
        Files.walk(p2).forEach(System.out::println);// Files.walk(p2)将P2路径下所有文件和子目录和子目录下的文件组成一个Path流
        System.out.println("Files.newDirectoryStream(p2)：");
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(p2))//返回p2路径下的文件和子目录（不包括子目录里面的内容），返回的不是Stream流而是一个迭代器的子接口DirectoryStream<Path>
        {
            for(Path p:entries)
                System.out.println(p);
        }
        //访问某个目录的所有子孙成员：static Path walkFileTree(Path start, FileVisitor<? super Path> visitor)
        //FileVisitor是一个接口，里面有四种抽象方法：
        //FileVisitResult postVisitDirectory(T dir, IOException exc)               一个目录被处理前
        //FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs)      一个目录被处理后
        //FileVisitResult visitFile(T file, BasicFileAttributes attrs)             访问一个文件或者目录时
        //FileVisitResult visitFileFailed(T file, IOException exc)                 访问文件或目录时发送错误
        //每种抽象方法都返回 FileVisitResult 。里面有四种枚举类型：
        //CONTINUE          继续访问下一个文件
        //SKIP_SIBLINGS     继续访问，但不访问此目录下的任何项
        //SKIP_SUBTREE      继续访问，但不访问这个文件的兄弟文件
        //TERMINATE      终止访问
        //SimpleFileVisitor实现了FileVisitor的方法，除了visitFileFailed方法全部返回CONTINUE
        Path p6 = Paths.get("D:","workplace","OnJava","ch17_file","test3");
        System.out.println(p6);
        RmDir.rmdir(p6);


    }
}
class RmDir
{
    //删除目录树
    public static void rmdir(Path dir) throws IOException
    {
        Files.walkFileTree(dir,new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            public FileVisitResult postVisitDirectory(Path dir,IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
