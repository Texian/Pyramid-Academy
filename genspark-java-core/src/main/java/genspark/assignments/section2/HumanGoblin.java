package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class HumanGoblin implements Assignment {
    public String solution(String str) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String action = str == "human" ? "You aRe one of us!" : "Attack the Goblin!";
        return action;
    }
}
