package genspark.assignments.section7;
import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class FilterMap implements Assignment {
    public Object[] solution(ArrayList<ArrayList<Integer>> listolists) {
        // ↓↓↓↓ your code goes here ↓↓↓↓\
        return listolists.stream()
                .filter(list -> list.size() > 0 && list.size() % 2 != 0)
                .map(sublist -> sublist.stream().map(i -> i * 10).collect(Collectors.toList()))
                .toArray();
    }
}
