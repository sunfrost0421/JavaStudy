package ch15_12;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try(
                Stream<String> in = Files.lines(Paths.get("abcd.txt"));
                PrintWriter outfile = new PrintWriter("Results.txt");
                ){
            in.limit(1).map(String::toUpperCase).forEachOrdered(outfile::println);
        }
    }
}
