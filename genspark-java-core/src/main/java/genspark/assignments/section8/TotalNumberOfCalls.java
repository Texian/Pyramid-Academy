package genspark.assignments.section8;

import genspark.assignments.Assignment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TotalNumberOfCalls implements Assignment {
    public int solution() throws IOException {
        // Get total number of unique numbers
        List<String> calls = Files.readAllLines(Paths.get("src/main/resources/calls.csv"));
        List<String> texts = Files.readAllLines(Paths.get("src/main/resources/texts.csv"));
        Set<String> numberSet = new HashSet<>();
        for (String call : calls) {
            String[] temp = call.split(",");
            numberSet.add(temp[0]);
            numberSet.add(temp[1]);
        }
        for (String text : texts) {
            String[] temp = text.split(",");
            numberSet.add(temp[0]);
            numberSet.add(temp[1]);
        }
        return numberSet.size();
    }
}

