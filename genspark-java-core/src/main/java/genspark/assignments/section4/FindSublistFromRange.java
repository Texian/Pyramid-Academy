package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindSublistFromRange implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> elms, int from, int to) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> substring = new ArrayList<>();
        try {
            if (from == to) {
                return substring;
            }
            for (int i = from; i < to; i++) {
                substring.add(elms.get(i));
            }
            return substring;
        } catch (Exception e) {
            return substring;
        }
    }
}
