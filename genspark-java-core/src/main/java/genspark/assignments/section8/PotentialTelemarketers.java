package genspark.assignments.section8;

import genspark.assignments.Assignment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class PotentialTelemarketers implements Assignment {
    public String solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> callList = Files.readAllLines(Paths.get("src/main/resources/calls.csv"));
        List<String> textList = Files.readAllLines(Paths.get("src/main/resources/texts.csv"));
        Set<String> outgoingCallSet = new HashSet<>();
        Set<String> textAndIncomingSet = new HashSet<>();
        for (String call : callList) {
            String[] temp = call.split(",");
            outgoingCallSet.add(temp[0]);
            textAndIncomingSet.add(temp[1]);

        }
        for (String text : textList) {
            String[] temp = text.split(",");
            textAndIncomingSet.add(temp[0]);
            textAndIncomingSet.add(temp[1]);
        }
        outgoingCallSet.removeAll(textAndIncomingSet);
        List<String> telemarketerList = new ArrayList<>(outgoingCallSet);
        Collections.sort(telemarketerList);
        String result = "";
        for(int i = 0; i < telemarketerList.size(); i++) {
            if(i != telemarketerList.size() - 1)result += telemarketerList.get(i) + " ";
            else result += telemarketerList.get(i);
        }
        //System.out.println(result);
        return result;
    }
}
