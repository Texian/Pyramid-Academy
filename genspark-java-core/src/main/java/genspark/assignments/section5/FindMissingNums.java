package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class FindMissingNums implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> missingNums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (!nums.contains(i+1)){
                missingNums.add(i+1);
            }
        } return missingNums;
    }
}
