package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ParenthesisBalance implements Assignment {
    public String solution(String s) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String b = "balanced", un = "unbalanced";
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        try {
            if (chars.size() > 1 && chars.get(0) == '(') {
                for (int i = 0; i < chars.size(); i++) {
                    if (chars.get(i) == '(') {
                        for (int j = i + 1; j < chars.size(); j++) {
                            if (chars.get(j) == ')') {
                                chars.remove(j);
                                chars.remove(i);
                            }
                        }
                    }
                }
                if (chars.size() == 0) {
                    return b;
                } else {
                    return un;
                }
            } else {
                return un;
            }
        } catch(IndexOutOfBoundsException e){
            return un;
        }
    }
}
