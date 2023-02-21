package fileSystem;

import java.nio.file.*;

public class FileSystemTest
{
    static void show (String id,Object o)
    {
        System.out.println(id + ": " + o);
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        //得到一个文件系统FileSystem
        // 方法一：FileSystems.getDefault();//返回系统的默认文件系统
        // 方法二：Path.getFileSystem();//返回路径所在的文件系统
        FileSystem fsys = FileSystems.getDefault();//返回系统的默认文件系统
        FileSystem fsys2 = Paths.get("FileSystemTest.java").getFileSystem();

        //Iterable<FileStore> getFileStores()，返回文件系统上的硬盘的迭代器
        for(FileStore fs : fsys.getFileStores())
        {
            show("File Store",fs);
        }
        //返回文件系统的根路径迭代器并遍历
        for(Path rd: fsys.getRootDirectories())
            show("Root Directory",rd);
        show("Separator", fsys.getSeparator());//返回该文件系统的目录分隔符
        show("UserPrincipalLookupService",
                fsys.getUserPrincipalLookupService());
        show("isOpen", fsys.isOpen());
        show("isReadOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        show("File Attribute Views",
                fsys.supportedFileAttributeViews());
    }
}
