package string;

import java.util.Formatter;

public class FormatterTest {
    public static void main(String[] args) {
        Formatter ft = new Formatter(System.out);//�������Ĳ���д���ַ�������ĵط�
        String fruit = "apple";
        ft.format("I like %s.",fruit);
    }
}
