package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAStringWhileLoop implements Assignment {
    public String solution(String str) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String reversed = "";
        int i = str.length() - 1;
        while (i >= 0) {
            reversed += str.charAt(i);
            i--;
        }
        return reversed;
    }
}
