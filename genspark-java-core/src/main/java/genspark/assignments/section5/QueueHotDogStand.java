package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;

public class QueueHotDogStand implements Assignment {
    public ArrayList<Integer> solution(ArrayList<Integer> list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            if (list.size() > 1) {
                for (int i = 0; i < 3; i++) {
                    list.add(list.get(0));
                    list.remove(0);
                }
            }
            return list;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
