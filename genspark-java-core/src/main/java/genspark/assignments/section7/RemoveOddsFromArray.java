package genspark.assignments.section7;

import genspark.assignments.Assignment;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class RemoveOddsFromArray implements Assignment {
    public int[] solution(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(nums)
                .filter(n -> n % 2 == 0)
                .toArray();
    }
}
