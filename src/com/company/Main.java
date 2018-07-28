package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("hello world");
        Path trainingsamplePath = Paths.get("trainingsample.csv");
        List<String> rows = Files.readAllLines(trainingsamplePath);
//        String[] splittedSampleRow = rows.get(123).split(",");
//        for (String column : splittedSampleRow) { System.out.println(column); }
        fruitsTest();
        List<String[]> rowsSplittedInColumns = rows.stream()
                .map(x -> x.split(","))
                .collect(Collectors.toList());
        System.out.println("done");
    }

    private static void fruitsTest() {
        List<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        fruits.add("strawberry");

        List<Integer> lengths = fruits.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());

        for (Integer length : lengths) { System.out.println(length); }

        fruits.stream()
                .map(x -> x.toUpperCase())
                .forEach(System.out::println);
    }
}
