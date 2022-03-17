package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.HashMap;

public class RetrieveValueFromGivenKey implements Assignment {
    public int solution(HashMap<Integer,Integer> map, Integer value) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            return map.get(value);
        } catch (Exception e) {
            return 0;
        }
    }
}
