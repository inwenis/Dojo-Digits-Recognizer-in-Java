package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {
    @Test
    public void test_computing_distance_between_points_on_line() {
        Integer[] pointA = new Integer[1];
        pointA[0] = 1;
        Integer[] pointB = new Integer[1];
        pointB[0] = 10;
        double distance = Main.distance(pointA, pointB);
        Assert.assertEquals(9, distance, 0);
    }

    @Test
    public void test_computing_distance_between_2D_points() {
        Integer[] pointA = new Integer[2];
        pointA[0] = 1;
        pointA[1] = 1;
        Integer[] pointB = new Integer[2];
        pointB[0] = 10;
        pointB[1] = 10;
        double distance = Main.distance(pointA, pointB);
        Assert.assertEquals(12.72, distance, 0.01);
    }
}