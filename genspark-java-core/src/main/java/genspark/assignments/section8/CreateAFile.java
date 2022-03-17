package genspark.assignments.section8;

import genspark.assignments.Assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateAFile implements Assignment {
    public void createAFile() {
        try {
            FileWriter sampleFile = new FileWriter("sample_data.txt");
            sampleFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToAFile() throws IOException {
        Path path = Paths.get("src/main/java/genspark/assignments/section8/sample_data.txt");
        byte[] data = "test".getBytes();
        Files.write(path, data);
    }

    public ArrayList<Character> readAFile() {
        try {
            List<String> file = Files.readAllLines(Paths.get("src/main/java/genspark/assignments/section8/sample_data.txt"));
            ArrayList<Character> charList = file.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.toCollection(ArrayList::new));

            System.out.println("CharList: " + charList);
            return charList;
        } catch (IOException e) {
            return null;
        }
//
    }
}
