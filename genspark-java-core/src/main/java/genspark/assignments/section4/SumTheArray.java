package genspark.assignments.section4;

import genspark.assignments.Assignment;

public class SumTheArray implements Assignment {
    public int solution(int[] numbers) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int sum = 0;
        try {
            for (int i : numbers) {
                sum += i;
            }
        } catch (Exception e) {
            return 0;
        } return sum;
    }
}
