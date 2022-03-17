package genspark.assignments.section4;

import genspark.assignments.Assignment;

public class ArrayContainsNumber implements Assignment {
    public boolean solution(int[] nums, int num) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            for (int i : nums) {
                if (i == num) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
