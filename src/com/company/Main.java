package com.company;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("hello world");
        Path trainingsamplePath = Paths.get("trainingsample.csv");
        List<String> lines = Files.readAllLines(trainingsamplePath);
//        String[] splittedSampleRow = lines.get(123).split(",");
//        for (String column : splittedSampleRow) { System.out.println(column); }
        fruitsTest();
        List<Record> records = lines.stream()
                .map(x -> x.split(","))
                .collect(Collectors.toList())
                .subList(1, lines.size()) // removes header row
                .stream()
                .map(x -> Arrays.stream(x)
                        .map(y -> Integer.parseInt(y))
                        .collect(Collectors.toList()))
                .map(x -> {
                    Record record = new Record();
                    record.Digit = x.get(0);
                    record.Pixels = x.subList(1, x.size()).toArray(new Integer[0]);
                    return record;
                })
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

        fruits.stream()
                .map(x -> {
                    FruitInfo fruitInfo = new FruitInfo();
                    fruitInfo.Name = x;
                    fruitInfo.DoILikeThisFruit = true;
                    return fruitInfo;
                })
                .forEach(x -> System.out.println(x.Name + " eat it: " + x.DoILikeThisFruit));
    }

    public static Integer recognize(Integer[] toBeRecognized, List<Record> sampleRecords) {
        Pair bestMatch = sampleRecords.stream()
                .map(x -> new Pair(x.Digit, distance(toBeRecognized, x.Pixels)))
                .sorted(Comparator.comparingDouble(x -> (double) x.getValue()))
                .findFirst()
                .get();

        Object bestMatchingDigit = bestMatch.getKey();
        return (Integer) bestMatchingDigit;
    }

    public static double distance(Integer[] pointA, Integer[] pointB) {
        int sum = 0;
        for (int i = 0; i < pointA.length; i++) {
            Integer diff = pointA[i] - pointB[i];
            sum += Math.pow(diff, 2);
        }
        return Math.sqrt(sum);
    }

    static class FruitInfo {
        public String Name;
        public boolean DoILikeThisFruit;
    }

    static class Record {
        public Integer Digit;
        public Integer[] Pixels;
    }
}
