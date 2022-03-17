package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class SwitchItUp implements Assignment {
    public String solution(int x) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String number;
        switch (x){
            case 1: number = "one";
                break;
            case 2: number = "two";
                break;
            case 3: number = "three";
                break;
            case 4: number = "four";
                break;
            case 5: number = "five";
                break;
            default: number = "none matched";
                break;
        }
        return number;
    }
}
