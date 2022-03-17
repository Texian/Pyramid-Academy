package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.Stack;

public class DeleteMiddleOfStack implements Assignment {
    public Stack<Integer> solution(Stack<Integer> stack) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int size = stack.size();
        try{
            if (stack.isEmpty() || size == 1) {
                return new Stack<>();
            } else if (size % 2 == 0) {
                stack.remove((size / 2) -1);
            } else {
                stack.remove(((size - 1) / 2));
            }
    } catch (Exception e) {
            return null;
        } return stack;
    }
}
