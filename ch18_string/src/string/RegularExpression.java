package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
//        //‘\’表示转义字符,要表示\需要用‘\\’
//        System.out.println("\\");
//        //在正则表达式中，“\d”表示一个数字，而一个反斜杠需要使用字符串中的'\\'来表示，使用为‘\\d’
//        System.out.println("1".matches("\\d"));
//        System.out.println("".matches("q?"));//可以匹配q，或者空字符（有一个q或者没有q）
//        Pattern p = Pattern.compile(".*abc.*");//包含有“abc"的字符串
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
