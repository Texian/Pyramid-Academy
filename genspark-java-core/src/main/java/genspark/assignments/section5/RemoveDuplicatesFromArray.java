package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.*;

public class RemoveDuplicatesFromArray implements Assignment {
    public int[] solution(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            int numlen = nums.length;
            if (numlen == 0 || numlen == 1){
                return nums;
            }
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int[] finalArray = new int[set.size()];
            int i = 0;
            for (int j : set) {
                finalArray[i++] = j;
            }
            return finalArray;
        } catch (Exception e) {
            return nums;
        }
    }
}
