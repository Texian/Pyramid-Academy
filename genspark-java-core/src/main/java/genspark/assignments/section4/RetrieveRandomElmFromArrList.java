package genspark.assignments.section4;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class RetrieveRandomElmFromArrList implements Assignment {
    public Integer solution(ArrayList<Integer> arrList, int elm) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            return arrList.get(elm);
        } catch (Exception e) {
            return 0;
        }
    }
}
