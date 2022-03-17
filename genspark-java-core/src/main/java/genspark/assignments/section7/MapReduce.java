package genspark.assignments.section7;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MapReduce implements Assignment {
    public int[] solution(ArrayList<ArrayList<Integer>> innerNums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return innerNums.stream()
                .filter(list -> list.size() > 0)
                .map(sublist -> sublist.stream()
                        .reduce(0, (a, b) -> a + b))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}


