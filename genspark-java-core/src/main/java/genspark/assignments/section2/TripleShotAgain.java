package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class TripleShotAgain implements Assignment {
    public boolean solution(boolean x, boolean y, boolean z) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return x == true ? true : y == true ? true : z == true ? true : false;
    }
}
