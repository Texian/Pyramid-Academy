package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class AddOneToArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (list.size() != 0) {
            try {
                int lastIndex = list.size() - 1, lastVal = list.get(lastIndex);
                int finalLastIndex = lastIndex;
                ArrayList<Integer> oneMore = new ArrayList<Integer>() {{
                    addAll(list);
                    int plusOne = lastVal + 1;
                    set(finalLastIndex, plusOne);
                }};
                if (oneMore.get(lastIndex) == 10) {
                    while (oneMore.get(lastIndex) == 10) {
                        oneMore.set(lastIndex, 0);
                        oneMore.set(lastIndex - 1, oneMore.get(lastIndex - 1) + 1);
                        lastIndex--;
                    }
                } return oneMore;
            } catch (Exception e) {
                return new ArrayList<>();
            }
        } return new ArrayList<>();
    }
    // ↑↑↑↑ your code goes here ↑↑↑↑
}
