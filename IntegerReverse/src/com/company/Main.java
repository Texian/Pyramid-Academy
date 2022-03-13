package com.company;

public class Main {

    public static int reverse(Integer num){
        char[] array = ("" + num).toCharArray();
        String yarra = "";
        for (int i = array.length-1; i>=0; i--){
            yarra += array;
        }
        int numYarra = Integer.parseInt(yarra);
        System.out.println(numYarra);
        return numYarra;
    }

    public static void main(String[] args) {
	// write your code here
        int i = 12898;
        reverse(i);
    }
}
