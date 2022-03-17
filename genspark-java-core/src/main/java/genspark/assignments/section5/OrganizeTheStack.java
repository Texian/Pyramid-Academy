package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.Stack;

public class OrganizeTheStack implements Assignment {
    public Stack<Integer> solution(Stack<Integer> stack) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        Stack<Integer> order = new Stack<>();
        while (!stack.isEmpty()) {
            int hold = stack.pop();
            while (!order.isEmpty() && order.peek() < hold) {
                stack.push(order.pop());
            }
            order.push(hold);
        }
        return order;
    }
}
