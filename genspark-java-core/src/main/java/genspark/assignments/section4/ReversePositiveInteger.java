package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePositiveInteger implements Assignment {
    public int solution(int number) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String numString = String.valueOf(number);
        ArrayList<Object> nums = new ArrayList<>(Arrays.asList(numString.split("")));
        String reversed = "";
        for (int i = nums.size() - 1; i >= 0; i--) {
            reversed += nums.get(i);
        }
        return Integer.parseInt(reversed);
    }
}
