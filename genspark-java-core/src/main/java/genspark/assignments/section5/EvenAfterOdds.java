package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class EvenAfterOdds implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> odds = new ArrayList<>(), evens = new ArrayList<>(), newOrder = new ArrayList<>();
        if (nums.size() == 0) return newOrder;
        for (int i : nums) {
            if (i % 2 == 0) evens.add(i);
            else odds.add(i);
        }
        newOrder.addAll(odds);
        newOrder.addAll(evens);
        return newOrder;
    }
}
