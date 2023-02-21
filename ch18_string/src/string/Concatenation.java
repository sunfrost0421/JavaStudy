package string;

import java.util.Locale;

public class Concatenation
{
    public static void main(String[] args)
    {
        String mango = "mango";
        String s = "abc"+mango+"def"+47;
        System.out.println(s);
        String s2 = s.toUpperCase();//String�ǲ��ɱ�ģ������᷵��һ���µ�String����
        System.out.println(s);
        System.out.println(s2);
        /*
        * 1��String�����ǲ��ɱ�ģ�StringBuilder�����ǿɱ��
        * 2��StringBuilder�����ַ������ܱ�String��
        * */
        StringBuilder sb = new StringBuilder("111");
// ������.length() ���г���
        System.out.println(sb.length());  // 0
// ������.append() ׷�ӵ�����
        sb.append("hello");
        System.out.println(sb);  // hello
// 97���������'a'
        sb.appendCodePoint(97);
        System.out.println(sb);  // helloa
// ��ʽ���
        sb.append(1).append("world").append(2);
        System.out.println(sb);  // helloa1world2
// ������5��λ���滻�ɿո�
        sb.setCharAt(5, ' ');
        System.out.println(sb);  // hello 1world2
// ָ��λ��0ǰ����0
        sb.insert(0, 0);
        System.out.println(sb);  // 0hello 1world2
// ɾ������6(����)������14(������)���ַ���
        sb.delete(6, 14);
        System.out.println(sb);  // 0hello
// StringBuilder����ת����String����
        String s3 = sb.toString();
        System.out.println(s3);  // 0hello

    }
}
