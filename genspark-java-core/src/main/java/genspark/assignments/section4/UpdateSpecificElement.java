package genspark.assignments.section4;

import genspark.assignments.Assignment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UpdateSpecificElement implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list, int val, int index) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            list.set(index, val);
        } catch (IndexOutOfBoundsException e) {
            return list;
        }
        return list;
    }
}