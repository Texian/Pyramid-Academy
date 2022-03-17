package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class RetrieveSpecifiedElement implements Assignment {
    public int solution(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            return list.get(0);
        } catch (Exception e) {
            return 0;
        }
    }
}
