package com.hbh7.day3;

import java.io.IOException;

public class day3part2 {

    public static void main(String[] args) throws IOException {

        int puzzleInput = 361527;
        puzzleInput++;

        /*
        37  36  35  34  33  32  31
        38  17  16  15  14  13  30
        39  18   5   4   3  12  29
        40  19   6   1   2  11  28
        41  20   7   8   9  10  27
        42  21  22  23  24  25  26
        43  44  45  46  47  48  49
        */

        int finalAnswer = 0;
        String direction = "right";

        // Build 2D array for mock coordinate system
        int range = 1000;
        int gridRange = (range*2)+1;
        int[][] grid = new int[gridRange][gridRange];
        int x = range;
        int y = range;

        int sumOfNeighbors = 1;

        for(int i = 1; sumOfNeighbors < puzzleInput; i++){

            // Calculate sum of neighbors
            if(i != 1)
            sumOfNeighbors = grid[x+1][y-1] + grid[x+1][y] + grid[x+1][y+1] +
                             grid[x][y-1] + grid[x][y] + grid[x][y+1] +
                             grid[x-1][y-1] + grid[x-1][y] + grid[x-1][y+1];

            grid[x][y] = sumOfNeighbors;


            println("Current Number: " + i + ". Going " + direction);
            println("Current sumOfNeighbors: " + sumOfNeighbors);
            if(i == puzzleInput-1)
                break;
            switch (direction) {
                case "right":
                    if (grid[x][y+1] == 0) {
                        direction = "up";
                        x = x;
                        y = y + 1;
                    } else {
                        x = x + 1;
                        y = y;
                    }
                    break;
                case "up":
                    if (grid[x - 1][y] == 0) {
                        direction = "left";
                        x = x - 1;
                        y = y;
                    } else {
                        x = x;
                        y = y + 1;
                    }
                    break;
                case "left":
                    if (grid[x][y-1] == 0) {
                        direction = "down";
                        x = x;
                        y = y - 1;
                    } else {
                        x = x - 1;
                        y = y;
                    }
                    break;
                case "down":
                    if (grid[x + 1][y] == 0) {
                        direction = "right";
                        x = x + 1;
                        y = y;
                    } else {
                        x = x;
                        y = y - 1;
                    }
                    break;
            }
            println("Going " + direction + " next.");
        }

        // Begin debug array printing
        for (int[] xp : grid)
        {
            for (int yp : xp)
            {
                if(yp != 0)
                    if(yp < 10) {
                        System.out.print("  " + yp + " ");
                    } else if(yp < 100) {
                        System.out.print(" " + yp + " ");
                    } else {
                        System.out.print(yp + " ");
                    }


            }
            System.out.println();
        }
        // End debug array printing

        finalAnswer = sumOfNeighbors;


        println("----------");
        println("Final Answer: " + finalAnswer);

    }
    public static void print(String statement) {
        System.out.print(statement);
    }
    public static void println(String statement) {
        System.out.println(statement);
    }
}


