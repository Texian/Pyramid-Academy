package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class MeanMedian implements Assignment {
    public String solution(int a, int b, int c) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        float mean = (a + b + c)/3f;
        int median = (a > b) ? (a < c ? a : ( b > c ? b : c)) : (a > c ? a : ( b > c ? c : b));
        String result = String.valueOf(mean) + " " + String.valueOf(median);
        return result;
    }
}
