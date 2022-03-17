package genspark.assignments.section7;

import genspark.assignments.Assignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryTheFile implements Assignment {
    public ArrayList<String> solution() {
        // ↓↓↓↓ your code goes here ↓↓↓↓

        try{
            Stream<String> input = Files.lines(Paths.get("src/main/resources/filter_problem.text"));
            ArrayList<String> file = new ArrayList<>();
            input.filter(s -> !s.contains("2")).forEach(file::add);
            return file;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
