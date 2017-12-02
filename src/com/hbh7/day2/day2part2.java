package com.hbh7.day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class day2part2 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day2/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;

        int finalAnswer = 0;
        int currentNum = 0;
        int divisionResult = 0;

        while ((line = br.readLine()) != null) {

            String[] splitString= line.split("\t");

            for (int i = 0; i < splitString.length; i++) {
                currentNum = Integer.parseInt(splitString[i]);
                for (int k = 0; k < splitString.length; k++) {
                    //println("currentNum: " + currentNum);
                    //println("Testing: " + k);
                    if ((currentNum % Integer.parseInt(splitString[k]) == 0 && currentNum != Integer.parseInt(splitString[k]))) {
                        divisionResult = currentNum / Integer.parseInt(splitString[k]);
                        println("Found " + currentNum + " divided by " + Integer.parseInt(splitString[k]) + " is " + divisionResult);
                    }
                }


            }
            finalAnswer = finalAnswer + divisionResult;
        }

        System.out.println("----------");
        System.out.println("Final Answer: " + finalAnswer);

        br.close();
    }
    public static void print(String statement) {
        System.out.print(statement);
    }
    public static void println(String statement) {
        System.out.println(statement);
    }
}


