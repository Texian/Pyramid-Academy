package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.List;

public class MaxSubArray implements Assignment {

    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int maxSum = Integer.MIN_VALUE, sum = 0, right = 0, left = right, start = left, end = right;
        if (nums.size() == 0 || nums.size() == 1) {
            return nums;
        }
        ArrayList<Integer> maxArray = null;
        try {
            for (right = 0; right < nums.size(); right++){
                if (sum <= 0){
                    left = right;
                    sum = nums.get(right);
                } else {
                    sum += nums.get(right);
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    start = left;
                    end = right + 1;
                }
            }
            if (start == end){
                maxArray.add(nums.get(end));
            } else {
                List<Integer> temp = nums.subList(start, end);
                maxArray = new ArrayList<Integer>(temp);
            }
        } catch (Exception e) {
            return null;
        }
        return maxArray;
    }
}
