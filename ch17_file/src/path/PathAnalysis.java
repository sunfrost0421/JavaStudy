package path;
/*����Files�ķ�������·��Path��Ϣ*/
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
        say("Exists", Files.exists(p));//�Ƿ����
        say("notExists", Files.notExists(p));//�Ƿ񲻴���

        /*�ж��ļ��Ƿ�ɶ�����д����ִ��
         * Files.isReadable(Path)
         * Files.isWritable(Path)
         * Files.isExecutable(Path)
         * */
        say("Readable", Files.isReadable(p));//�Ƿ�ɶ�
        say("Writable", Files.isWritable(p));//�Ƿ��д
        say("Executable", Files.isExecutable(p));//�Ƿ�Ϊ��ִ���ļ�

        /*�ж��ļ��Ƿ�Ϊ�����ļ���Ŀ¼����������
        * Files.isRegularFile(Path)
        * Files.isDirectory(Path)
        * Files.isSymbolicLink(Path)
        * */
        say("RegularFile", Files.isRegularFile(p));//�Ƿ�Ϊ��ͨ�ļ�
        say("Directory", Files.isDirectory(p));//�Ƿ�Ϊ��ͨ�ļ�
        say("SymbolicLink", Files.isSymbolicLink(p));//�Ƿ�Ϊ��ͨ�ļ�

        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));//�����ļ����ֽ���
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
