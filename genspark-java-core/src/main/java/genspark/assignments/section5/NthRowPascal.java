package genspark.assignments.section5;

import genspark.assignments.Assignment;

import java.math.BigInteger;
import java.util.ArrayList;

public class NthRowPascal implements Assignment {
    public ArrayList<Integer> solution(int nth) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int rowSum = (int) Math.pow(2, nth);
        ArrayList<Integer> rowNums = new ArrayList<>();

        for (int i = 0; i < nth+1; i++) {
            long elem = fac(nth)/(fac(i)*fac(nth-i));
            rowNums.add((int) elem);
        }
        return rowNums;
    }
    public static long fac(int n) {
        long factorial = 1;
        for (long i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

//4!/3!(4-3)! = 24/6(1) = 4