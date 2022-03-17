package genspark.assignments.section4;

import genspark.assignments.Assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class IterateThroughArrayList implements Assignment {
    public ArrayList<Integer> solution(ArrayList<String> myList) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> countList = new ArrayList<>();
        for (String s : myList) {
            int count = 0;
            while (count < s.length()) {
                count++;
            }
            countList.add(count);
        }
        return countList;
    }
}