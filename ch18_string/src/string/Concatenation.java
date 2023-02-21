package string;

import java.util.Locale;

public class Concatenation
{
    public static void main(String[] args)
    {
        String mango = "mango";
        String s = "abc"+mango+"def"+47;
        System.out.println(s);
        String s2 = s.toUpperCase();//String是不可变的，方法会返回一个新的String对象
        System.out.println(s);
        System.out.println(s2);
        /*
        * 1、String内容是不可变的，StringBuilder内容是可变的
        * 2、StringBuilder处理字符串性能比String好
        * */
        StringBuilder sb = new StringBuilder("111");
// 对象名.length() 序列长度
        System.out.println(sb.length());  // 0
// 对象名.append() 追加到序列
        sb.append("hello");
        System.out.println(sb);  // hello
// 97代表的是是'a'
        sb.appendCodePoint(97);
        System.out.println(sb);  // helloa
// 链式编程
        sb.append(1).append("world").append(2);
        System.out.println(sb);  // helloa1world2
// 索引是5的位置替换成空格
        sb.setCharAt(5, ' ');
        System.out.println(sb);  // hello 1world2
// 指定位置0前插入0
        sb.insert(0, 0);
        System.out.println(sb);  // 0hello 1world2
// 删除索引6(包含)至索引14(不包含)的字符串
        sb.delete(6, 14);
        System.out.println(sb);  // 0hello
// StringBuilder类型转换成String类型
        String s3 = sb.toString();
        System.out.println(s3);  // 0hello

    }
}
