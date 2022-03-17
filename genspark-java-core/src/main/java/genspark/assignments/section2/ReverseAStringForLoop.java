package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAStringForLoop implements Assignment {
    public String solution(String str) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
