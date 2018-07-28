package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        Path trainingsamplePath = Paths.get("trainingsample.csv");
        Files.readAllLines(trainingsamplePath);
        System.out.println("done");
    }
}
