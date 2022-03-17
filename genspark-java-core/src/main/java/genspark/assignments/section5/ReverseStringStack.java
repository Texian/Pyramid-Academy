package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.util.Stack;

public class ReverseStringStack implements Assignment {
    public String solution(String word) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (word.length() <= 1) {
            return word;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = word.length(); i > 0; i--) {
            stack.push(word.charAt(i - 1));
        }
        String stringStack = "";
        for (int i = 0; i < stack.size(); i++) {
            stringStack += stack.get(i);
        }
        return stringStack;
    }
}
