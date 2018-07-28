package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("hello world");
        Path trainingsamplePath = Paths.get("trainingsample.csv");
        List<String> lines = Files.readAllLines(trainingsamplePath);
//        String[] splittedSampleRow = lines.get(123).split(",");
//        for (String column : splittedSampleRow) { System.out.println(column); }
        fruitsTest();
        List<List<Integer>> rows = lines.stream()
                .map(x -> x.split(","))
                .collect(Collectors.toList())
                .subList(1, lines.size()) // removes header row
                .stream()
                .map(x -> Arrays.stream(x)
                        .map(y -> Integer.parseInt(y))
                        .collect(Collectors.toList()))
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
