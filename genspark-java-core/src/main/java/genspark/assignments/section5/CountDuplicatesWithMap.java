package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.HashMap;

public class CountDuplicatesWithMap implements Assignment {
    public HashMap<Integer,Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (nums.size() != 0) {
            HashMap<Integer, Integer> duplicates = new HashMap<>();
            if (nums.size() == 1) {
                duplicates.put(nums.get(0), 1);
                return duplicates;
            }
            for (int i : nums) {
                if (duplicates.containsKey(i)) {
                    duplicates.replace(i, duplicates.get(i), duplicates.get(i) + 1);
                } else {
                    duplicates.put(i, 1);
                }
            }
            return duplicates;
        } return null;
    }
}
