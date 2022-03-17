package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CheckForPalindrome implements Assignment {
    public boolean solution(String pally) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String yllap = "";
        int i = pally.length() - 1;
        while (i >= 0) {
            yllap += pally.charAt(i);
            i--;
        }
        return pally.length() == 0 || (pally.equals(yllap));
    }
}
