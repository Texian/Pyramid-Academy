package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class LastIndexFound implements Assignment {
    public int solution(ArrayList<Integer> nums, int numToFind) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int index = 0;
        if (!nums.contains(numToFind)) {
            return -1;
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == numToFind) {
                    index = i;
                }
            }
        }
        return index;
    }
}
