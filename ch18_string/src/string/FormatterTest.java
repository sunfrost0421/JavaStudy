package string;

import java.util.Formatter;

public class FormatterTest {
    public static void main(String[] args) {
        Formatter ft = new Formatter(System.out);//构造器的参数写入字符串输出的地方
        String fruit = "apple";
        ft.format("I like %s.",fruit);
    }
}
