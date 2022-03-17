package genspark.assignments.section2;

import genspark.assignments.Assignment;

public class FizzBuzzBaz implements Assignment {
    public String solution(int fuzzy) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return fuzzy % 5 == 0 && fuzzy % 3 == 0 ? "fizz buzz baz" : fuzzy % 5 == 0 ? "buzz" : fuzzy % 3 == 0 ? "fizz" : "Fizzled";
    }
}
