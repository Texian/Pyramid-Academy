package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class CheckingAGrade implements Assignment {
    public String solution(int grade) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return grade >= 90 ? "A" : grade >= 80 ? "B" : grade >= 70 ? "C" : "FAILURE";
    }
}
