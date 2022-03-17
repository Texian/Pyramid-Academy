package genspark.assignments.section2;

import genspark.assignments.Assignment;
import org.objectweb.asm.Type;

public class TypeConversion implements Assignment {
    public Object solution(Object object) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if (object.getClass() == String.class) {
            return Integer.parseInt((String) object);
        }
        return object.toString();
    }
}
