package genspark.assignments.section8;

import genspark.assignments.Assignment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class RecordOfTextsAndCalls implements Assignment {
    public String[] solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            List<String> calls = Files.readAllLines(Paths.get("src/main/resources/calls.csv"));
            List<String> texts = Files.readAllLines(Paths.get("src/main/resources/texts.csv"));
            String[] lastCall = calls.get(calls.size() - 1).split(",");
            String[] firstText = texts.get(0).split(",");
            String[] result = new String[2];
            result[0] = "First record of texts, " + firstText[0] + " texts " + firstText[1] + " at time " + firstText[2];
            result[1] = "Last record of calls, " + lastCall[0] + " calls " + lastCall[1] + " at time " + lastCall[2] + ", lasting " + lastCall[3] + " seconds";
            System.out.println(result[0] + result[1]);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
