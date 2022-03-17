package genspark.assignments.section8;

import genspark.assignments.Assignment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutgoingCallsFromBangalore implements Assignment {
    public String solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String result = Files.readAllLines(Paths.get("src/main/resources/calls.csv")).stream()
                .map(call -> {
                    String[] temp = call.split(",");
                    int parend = temp[0].indexOf(")");
                    return temp[0].charAt(0) == '(' ? temp[0].substring(1, parend) : temp[0].substring(0, 4);
                }).distinct()
                .filter(s -> !s.startsWith("140"))
                .sorted(Comparator.naturalOrder()).reduce("", (acc, next) -> acc + next + " ").trim();
        System.out.println(result);
        return result;
    }
}
//
//.filter(call -> {
//        String[] temp = call.split(",");
//        return temp[0].substring(0, 5).equals("(080)");
//        }).