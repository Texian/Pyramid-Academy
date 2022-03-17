package genspark.assignments.section5;

import genspark.assignments.Assignment;
import java.util.HashMap;
import java.util.Map;

public class CreateAHuman implements Assignment {
    public HashMap<String, Object> solution(String name, Long age) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        try {
            HashMap<String, Object> human = new HashMap<String, Object>();
            if (name != null && age != null) {
                human.put("name", name);
                human.put("age", age);
            } else {
                return null;
            }
            for (Map.Entry person : human.entrySet()) {
                return human;
            }
        } catch (Exception e) {
            return null;
        } return null;
    }
}
