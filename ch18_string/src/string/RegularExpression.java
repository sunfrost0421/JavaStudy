package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
//        //��\����ʾת���ַ�,Ҫ��ʾ\��Ҫ�á�\\��
//        System.out.println("\\");
//        //��������ʽ�У���\d����ʾһ�����֣���һ����б����Ҫʹ���ַ����е�'\\'����ʾ��ʹ��Ϊ��\\d��
//        System.out.println("1".matches("\\d"));
//        System.out.println("".matches("q?"));//����ƥ��q�����߿��ַ�����һ��q����û��q��
//        Pattern p = Pattern.compile(".*abc.*");//�����С�abc"���ַ���
//        Matcher m = p.matcher("eeeabc");
//        System.out.println(m.matches());
//        System.out.println(Pattern.matches("abc+?","abcabcabc"));
//        while(m.find()){
//            System.out.println(
//                    "Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1)
//            );
//        }
        Pattern p = Pattern.compile("abc+");
        Matcher m = p.matcher("abccccabccabc");
        System.out.println(m.matches());
        int i = 0;
        while(m.find(i)){
            System.out.println("epoch:"+i);
            System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            i++;
        }
        Pattern p1 = Pattern.compile("(?m)^abc");
        Pattern p2 = Pattern.compile("^abc",Pattern.MULTILINE);
        System.out.println(Pattern.matches("^abc.*", "abcdef"));
        String tx ="s_safasfasfqewgsvzvd";
        boolean t = Pattern.matches("^[a-zA-Z]\\w*$", tx);
        System.out.println(t);

    }
}
