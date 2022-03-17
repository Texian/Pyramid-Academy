package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class FindMissingInteger implements Assignment {
    public int solution(ArrayList<Integer> numbers) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (numbers.size() == 0) return 0;
        if (numbers.get(0) != 1 || numbers.get(numbers.size() - 1) != numbers.size()) {
            int fullSum = 0, shortSum = 0;
            try {
                for (int i = 1; i <= numbers.size() + 1; i++) {
                    fullSum += i;
                }
                for (int i : numbers) {
                    shortSum += i;
                }
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
            return fullSum - shortSum;
        } return 0;
    }
}