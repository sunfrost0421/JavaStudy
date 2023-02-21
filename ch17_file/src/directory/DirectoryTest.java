package directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/*
* Ŀ¼��ʾ�����ļ���
*
* */
public class DirectoryTest
{
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("D:","workplace","OnJava","ch17_file","test1");
        System.out.println(p1);
        //Files.createDirectory(p1);//��ָ��·�������ļ��У�Ҫ��·���������һ�������⣬ǰ�涼���Ѿ�ʵ�ʴ��ڵ�
        System.out.println(Files.isDirectory(p1));
        Path p2 = Paths.get("D:","workplace","OnJava","ch17_file","test2","qrc","love","hjx");
        System.out.println("p2:  "+p2);
        //Files.createDirectories(p2);//��ָ��·�������ļ��У����·�������кܶ�ʵ�ʲ����ڵĲ���
        Path p3 = p2.resolve("loveYou.txt");
        System.out.println("p3:  "+p3);
        //Files.createFile(p3);//��ָ��λ�ô����ļ�
        Path p4 = p2.getParent().resolve("loveYou.txt");
        System.out.println("p4:  "+p4);
        //Files.copy(p3,p4);//�����ļ���ָ��·����Դ�ļ���������ָ��·�������ļ��������쳣
        Path p5 = p4.getParent().getParent().resolve("loveYou.txt");
        System.out.println("p5:  "+p5);
        //Files.move(p4,p5);//�ƶ��ļ���ָ��·����Դ�ļ�ɾ������ָ��·�������ļ��������쳣
        //��ָ��·�������ļ���������Ӳ���StandardCopyOption.REPLACE_EXISTING����ʾ���������ļ�
        Files.copy(p3,p5,StandardCopyOption.REPLACE_EXISTING);
        Files.delete(p5);//ɾ���ļ�,���ļ������ڣ������쳣�����Բ�����������취
        System.out.println(Files.deleteIfExists(p5));//���ļ������ڣ�������������false
        //Files.delete(p1);//Ҳ����ɾ��Ŀ¼��Ҳ�����ļ��У���ֻ��ɾ�������һ���Ŀ�Ŀ¼

        System.out.println("Files.list(p2)��");
        Files.list(p2).forEach(System.out::println);// Files.list(p2)��P2·���������ļ�����������Ŀ¼�����һ��Path��
        System.out.println("Files.walk(p2)��");
        Files.walk(p2).forEach(System.out::println);// Files.walk(p2)��P2·���������ļ�����Ŀ¼����Ŀ¼�µ��ļ����һ��Path��
        System.out.println("Files.newDirectoryStream(p2)��");
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(p2))//����p2·���µ��ļ�����Ŀ¼����������Ŀ¼��������ݣ������صĲ���Stream������һ�����������ӽӿ�DirectoryStream<Path>
        {
            for(Path p:entries)
                System.out.println(p);
        }
        //����ĳ��Ŀ¼�����������Ա��static Path walkFileTree(Path start, FileVisitor<? super Path> visitor)
        //FileVisitor��һ���ӿڣ����������ֳ��󷽷���
        //FileVisitResult postVisitDirectory(T dir, IOException exc)               һ��Ŀ¼������ǰ
        //FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs)      һ��Ŀ¼�������
        //FileVisitResult visitFile(T file, BasicFileAttributes attrs)             ����һ���ļ�����Ŀ¼ʱ
        //FileVisitResult visitFileFailed(T file, IOException exc)                 �����ļ���Ŀ¼ʱ���ʹ���
        //ÿ�ֳ��󷽷������� FileVisitResult ������������ö�����ͣ�
        //CONTINUE          ����������һ���ļ�
        //SKIP_SIBLINGS     �������ʣ��������ʴ�Ŀ¼�µ��κ���
        //SKIP_SUBTREE      �������ʣ�������������ļ����ֵ��ļ�
        //TERMINATE      ��ֹ����
        //SimpleFileVisitorʵ����FileVisitor�ķ���������visitFileFailed����ȫ������CONTINUE
        Path p6 = Paths.get("D:","workplace","OnJava","ch17_file","test3");
        System.out.println(p6);
        RmDir.rmdir(p6);


    }
}
class RmDir
{
    //ɾ��Ŀ¼��
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
