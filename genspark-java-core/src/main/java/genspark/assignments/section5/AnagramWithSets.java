package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.HashSet;

public class AnagramWithSets implements Assignment {
    public boolean solution(String word1, String word2) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (word1.length() == word2.length() && !word1.equals(word2)) {
            HashSet<Character> wordSet = new HashSet<>(), wordSet2 = new HashSet<>();
            for (char c : word1.toCharArray()) {
                wordSet.add(c);
            }
            for (char c : word2.toCharArray()) {
                wordSet2.add(c);
            }

            try {
                if (wordSet.removeAll(wordSet2) == wordSet.isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
