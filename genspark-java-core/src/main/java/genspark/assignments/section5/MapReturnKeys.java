package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.ArrayList;
import java.util.HashMap;

public class MapReturnKeys implements Assignment {
    public ArrayList<String> solution(HashMap<String,Integer> map){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (map == null) {
            return null;
        }
        ArrayList<String> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        return keys;
    }
}
