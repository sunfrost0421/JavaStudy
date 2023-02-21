package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    public static void main(String[] args) {
//        String input = "1!!222!!33";
//        Pattern p = Pattern.compile("!!");
//        Matcher m = p.matcher(input);
//        System.out.println(Arrays.toString(
//                p.split(input)
//        ));
//        System.out.println(m.replaceAll("--"));
//        System.out.println(m.replaceFirst(".."));
//        m.reset();
//        StringBuffer sb = new StringBuffer();
//        while(m.find()){
//            m.appendReplacement(sb, "++");
//        }
//
//        System.out.println(sb);
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        //m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
