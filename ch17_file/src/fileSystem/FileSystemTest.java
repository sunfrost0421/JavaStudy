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
        //�õ�һ���ļ�ϵͳFileSystem
        // ����һ��FileSystems.getDefault();//����ϵͳ��Ĭ���ļ�ϵͳ
        // ��������Path.getFileSystem();//����·�����ڵ��ļ�ϵͳ
        FileSystem fsys = FileSystems.getDefault();//����ϵͳ��Ĭ���ļ�ϵͳ
        FileSystem fsys2 = Paths.get("FileSystemTest.java").getFileSystem();

        //Iterable<FileStore> getFileStores()�������ļ�ϵͳ�ϵ�Ӳ�̵ĵ�����
        for(FileStore fs : fsys.getFileStores())
        {
            show("File Store",fs);
        }
        //�����ļ�ϵͳ�ĸ�·��������������
        for(Path rd: fsys.getRootDirectories())
            show("Root Directory",rd);
        show("Separator", fsys.getSeparator());//���ظ��ļ�ϵͳ��Ŀ¼�ָ���
        show("UserPrincipalLookupService",
                fsys.getUserPrincipalLookupService());
        show("isOpen", fsys.isOpen());
        show("isReadOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        show("File Attribute Views",
                fsys.supportedFileAttributeViews());
    }
}
