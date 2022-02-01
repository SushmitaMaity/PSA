/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // FIXME do move by replacing the following code
         //throw new RuntimeException("Not implemented");
        x += dx;
        y += dy;
        // END 
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        // FIXME
        for(int i = 0; i < m; i++)
            randomMove();
        // END 
    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // FIXME
        return Math.sqrt(x*x + y*y);
        // END
       // return 0;
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance / n;
    }

public static void main(String[] args) {

    int[] m = {0, 50, 110, 180, 260, 420, 560, 700, 900, 1000};  // Number of steps
    int[] n = {100, 300, 500, 700, 1000, 2000, 6000, 7000, 8000, 9000 };  // Number of experiments
    for(int i = 0; i < m.length; i++) {
        for (int j =0; j < n.length; j++) {
            double meanDistance = randomWalkMulti(m[i], n[j]);
            System.out.println(m[i] + " steps: " + meanDistance + " over " + n[j] + " experiments");
        }
    }
}
}
