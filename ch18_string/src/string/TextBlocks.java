package string;

public class TextBlocks {
    public static String S1 = """
            N1 = %d,
            N2 = %d,
            sum = %d!
            """;

    public static void main(String[] args) {
        System.out.println("------");
        System.out.println(S1.formatted(1,1,1+1));
        System.out.println("------");
    }
}

