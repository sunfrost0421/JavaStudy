package directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewFile
{
    public static void main(String[] args) throws IOException {
        var p1 = Paths.get("hello.txt").toAbsolutePath().getParent();
        System.out.println(p1);
        var p2 = p1.resolveSibling("ch18_string");
        System.out.println(p2);
        Files.createDirectory(p2);
    }
}
