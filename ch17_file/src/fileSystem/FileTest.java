package fileSystem;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest
{
    public static void main(String[] args) throws IOException {
        /*文件的读操作
        * Files.readAllBytes(Path)
        * Files.readAllLines(Path)
        * */
        Path p1 = Paths.get("hello.txt");
        byte[] bytes = Files.readAllBytes(p1);
        System.out.println(Arrays.toString(bytes));
        List<String> lines = Files.readAllLines(p1);
        System.out.println(lines);
        /*文件的写操作
        * Files.write(),可以将任何实现了Iterable接口的类的对象写入文件。会覆盖原有内容
        *
        * */
        ArrayList<String> words = new ArrayList<>();
        words.add("ly");
        words.add("zzy");
        words.add("zqq");
        Files.write(Paths.get("hello.txt"),words);

        /*文件的查找操作,Files.walk(Path).转化为流用过滤器查找
         * toString,用字符串比较
         * PathMatcher.matches(path)，构建PathMatcher时，需要用到用glob表达式.
         * */
        Files.walk(Paths.get("test2"))
                .filter(path->path.getFileName().toString().endsWith(".txt"))
                .forEach(System.out::println);
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.txt");//构建
        Files.walk(Paths.get("test2"))
                .filter(path->matcher.matches(path))
                .forEach(System.out::println);



    }
}
