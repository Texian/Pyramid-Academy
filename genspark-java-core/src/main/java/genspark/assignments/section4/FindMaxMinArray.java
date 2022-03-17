package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxMinArray implements Assignment {
    public ArrayList<Long> solution(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Long> minMax = new ArrayList<Long>(Arrays.asList(0L,0L));
        ArrayList<Long> empty = new ArrayList<Long>(Arrays.asList(0L, 0L));
        try {
            if (nums.length == 0) {
                return empty;
            } else if (nums.length == 1) {
                minMax.set(0, (long) nums[0]);
                minMax.set(1, (long) nums[0]);
                return minMax;
            }
            for (int i : nums) {
                if (i <= minMax.get(0)) {
                    if (i <= minMax.get(1)) {
                        minMax.set(1, (long) i);
                    }
                } else if (i >= minMax.get(1)) {
                    if (i >= minMax.get(0)) {
                        minMax.set(0, (long) i);
                    }
                } else {
                    return empty;
                }
            }
        } catch (Exception e) {
            return empty;
        }
        return minMax;
    }
}
