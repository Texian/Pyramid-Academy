package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class LongestString implements Assignment {
    public String solution(String firstWord, String secondWord) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String longest = firstWord.length() > secondWord.length() ? firstWord : secondWord;
        return longest;
    }
}
