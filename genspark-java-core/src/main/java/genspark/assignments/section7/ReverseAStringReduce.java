package genspark.assignments.section7;

import genspark.assignments.Assignment;

import java.util.Arrays;

public class ReverseAStringReduce implements Assignment {
    public String solution(String word) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(word.split(""))
                .reduce("", (a, b) -> b + a);
    }
}
