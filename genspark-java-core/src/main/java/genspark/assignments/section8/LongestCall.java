package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LongestCall implements Assignment {
    public String solution() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/calls.csv"));
        Map<String, Integer> countMap = new HashMap<>();
        for (String call : input) {
            String[] temp = call.split(",");
            if(countMap.containsKey(temp[0])) {
                Integer countTemp = countMap.get(temp[0]) + Integer.parseInt(temp[3]);
                countMap.put(temp[0], countTemp);
            } else countMap.put(temp[0], Integer.parseInt(temp[3]));
            if(countMap.containsKey(temp[1])) {
                Integer countTemp = countMap.get(temp[1]) + Integer.parseInt(temp[3]);
                countMap.put(temp[1], countTemp);
            } else countMap.put(temp[1], Integer.parseInt(temp[3]));
        }
        String result = "";
        Integer longestCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if(result.equals("")) {
                result = entry.getKey();
                longestCount = entry.getValue();
            }
            else if(longestCount < entry.getValue()) {
                result = entry.getKey();
                longestCount = entry.getValue();
            }
        }
        return result;
    }
}
