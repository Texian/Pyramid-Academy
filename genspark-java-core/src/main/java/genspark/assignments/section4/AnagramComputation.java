package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;

public class AnagramComputation implements Assignment {
    public boolean solution(String word1, String word2) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Character> word1List = new ArrayList<Character>(), word2List = new ArrayList<Character>();
        for (char c: word1.toCharArray()) { word1List.add(c); }
        for (char c: word2.toCharArray()) { word2List.add(c); }
        try {
            if ((word1List.size() == word2List.size() && !word1List.equals(word2List)) ) {
                if (word1List.removeAll(word2List) == word1List.isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }
    }
}
