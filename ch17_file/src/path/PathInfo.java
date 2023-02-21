package path;
/**
 * Path�������һ���ļ���Ŀ¼����·���������ڲ�ͬ�Ĳ���ϵͳ���ļ�ϵͳ֮�ϵĳ���
 * ����Path֮�����ǲ���ע��ײ�Ĳ���ϵͳ�����벻��Ҫ��д�Ϳ����ڲ�ͬ�Ĳ���ϵͳ���湤��
 * ·�����ض�Ӧ��ʵ�ʴ��ڵ��ļ����෴����Ҫ�����ļ�������Ҫ����һ��·����Ȼ����÷��������ļ�
 * ��̬��Paths.get(String/uri)
 * Path.resolve(Path)
 *
 * */
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo
{
    public static void main(String[] args)
    {
        /*Paths.get():��·���ַ���������Ϊ·���ַ���ʱ�γɵ��ַ�������ת��Ϊ·����*/
        //D:\workpalce\OnJava\ch17_file�����ڲ�ͬ�Ĳ���ϵͳ�ָ������ܲ�һ��
        //����Paths.get���Խ�����·�������ָ�����ʹ�õĲ���ϵͳ��ϳ�һ��Path����
        Path p1 = Paths.get("D:","workplace","OnJava","ch17_file");//����·������
        System.out.println(p1);
        Path p2 = Paths.get("PathInfo.java");//�ڵ�ǰjava�ļ�����·��(�����ļ���·��)�½������·��
        System.out.println(p2);
        System.out.println(p2.toAbsolutePath());
        Path p3 = Paths.get("aaa.txt");//�ڵ�ǰjava�ļ�����·��(�����ļ���·��)�½������·�����󣬼�ʹ�ļ�������
        System.out.println(p3);
        System.out.println(p3.toAbsolutePath());

        Path p4 = p2.toAbsolutePath();//�õ�p2�ľ���·����p4��ʾ��λ����p2һ��

        //��־���·������ֲ���ʾ��·��D:
        for(int i = 0;i<p4.getNameCount();i++)
        {
            System.out.println(p4.getName(i));
        }
        //endsWith(x)�����ж�·�������һ������ǲ���x
        System.out.println("PathInfo.java����·����PathInfo.java������"+p4.endsWith("PathInfo.java"));
        System.out.println("PathInfo.java����·����.java������"+p4.endsWith(".java"));
        //startsWith(x)�����ж�x�Ƿ�Ϊ·���ĸ�ΪD��\��ע���޷�ͨ��getName(i)�õ���·��
        System.out.println("PathInfo.java����·����workplace��ʼ��"+p4.startsWith("workpalce"));
        System.out.println("PathInfo.java����·����D:\\��ʼ��"+p4.startsWith("D:\\"));

        System.out.println(p4.getRoot());
        System.out.println("p4:  "+p4);
//        System.out.println(p4.resolve("ADD"));
//        System.out.println(p4.getParent());//�õ���һ��·��
        Path p5 = p4.resolveSibling("ADD2");//����p4��ͬ��·��
        System.out.println("p5:  "+p5);
        System.out.println(p5.getFileName());//����·�������һ������
        System.out.println(p4.relativize(p5));//p5�����p4��·��
        System.out.println(p5.relativize(p4));//p4�����p5��·��
    }
}
