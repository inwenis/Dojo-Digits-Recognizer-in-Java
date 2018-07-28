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
}