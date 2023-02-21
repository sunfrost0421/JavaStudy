package path;
/*利用Files的方法分析路径Path信息*/
import java.nio.file.*;
import java.io.IOException;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path p =
                Paths.get("src","path","PathAnalysis.java").toAbsolutePath();
        System.out.println(p);
        say("Exists", Files.exists(p));//是否存在
        say("notExists", Files.notExists(p));//是否不存在

        /*判断文件是否可读、可写、可执行
         * Files.isReadable(Path)
         * Files.isWritable(Path)
         * Files.isExecutable(Path)
         * */
        say("Readable", Files.isReadable(p));//是否可读
        say("Writable", Files.isWritable(p));//是否可写
        say("Executable", Files.isExecutable(p));//是否为可执行文件

        /*判断文件是否为常规文件、目录、符号链接
        * Files.isRegularFile(Path)
        * Files.isDirectory(Path)
        * Files.isSymbolicLink(Path)
        * */
        say("RegularFile", Files.isRegularFile(p));//是否为普通文件
        say("Directory", Files.isDirectory(p));//是否为普通文件
        say("SymbolicLink", Files.isSymbolicLink(p));//是否为普通文件

        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));//返回文件的字节数
        say("FileStore", Files.getFileStore(p));
//        say("LastModified: ", Files.getLastModifiedTime(p));
//        say("Owner", Files.getOwner(p));
//        say("ContentType", Files.probeContentType(p));
//        say("SymbolicLink", Files.isSymbolicLink(p));
//        if(Files.isSymbolicLink(p))
//            say("SymbolicLink", Files.readSymbolicLink(p));
//        if(FileSystems.getDefault()
//                .supportedFileAttributeViews().contains("posix"))
//            say("PosixFilePermissions",
//                    Files.getPosixFilePermissions(p));
    }
}
/* Output:
Windows 10
Exists: true
Directory: false
Executable: true
Readable: true
RegularFile: true
Writable: true
notExists: false
Hidden: false
size: 1617
FileStore: (C:)
LastModified: : 2021-11-08T00:34:52.693768Z
Owner: GROOT\Bruce (User)
ContentType: text/plain
SymbolicLink: false
*/
