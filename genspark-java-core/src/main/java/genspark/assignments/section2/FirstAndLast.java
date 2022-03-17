package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class FirstAndLast implements Assignment {
    public boolean solution(String word) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (word.length() > 0)  {
            return word.charAt(0) == word.charAt(word.length()-1) ? true : false;
        }
        return true;
    }
}
