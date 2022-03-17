package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class ReverseAnInteger implements Assignment {
    public String solution(int number) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String reverse = "";
        String numString = Integer.toString(number);
        int i = numString.length() - 1;
            while (reverse.length() < numString.length()) {
                reverse += numString.charAt(i);
                i--;
            }
        return reverse;
    }
}
