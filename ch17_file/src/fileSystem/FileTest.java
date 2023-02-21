package fileSystem;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest
{
    public static void main(String[] args) throws IOException {
        /*�ļ��Ķ�����
        * Files.readAllBytes(Path)
        * Files.readAllLines(Path)
        * */
        Path p1 = Paths.get("hello.txt");
        byte[] bytes = Files.readAllBytes(p1);
        System.out.println(Arrays.toString(bytes));
        List<String> lines = Files.readAllLines(p1);
        System.out.println(lines);
        /*�ļ���д����
        * Files.write(),���Խ��κ�ʵ����Iterable�ӿڵ���Ķ���д���ļ����Ḳ��ԭ������
        *
        * */
        ArrayList<String> words = new ArrayList<>();
        words.add("ly");
        words.add("zzy");
        words.add("zqq");
        Files.write(Paths.get("hello.txt"),words);

        /*�ļ��Ĳ��Ҳ���,Files.walk(Path).ת��Ϊ���ù���������
         * toString,���ַ����Ƚ�
         * PathMatcher.matches(path)������PathMatcherʱ����Ҫ�õ���glob���ʽ.
         * */
        Files.walk(Paths.get("test2"))
                .filter(path->path.getFileName().toString().endsWith(".txt"))
                .forEach(System.out::println);
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.txt");//����
        Files.walk(Paths.get("test2"))
                .filter(path->matcher.matches(path))
                .forEach(System.out::println);



    }
}
