package com.hbh7.day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class day2part1 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day2/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;

        int finalAnswer = 0;
        int prevNum = 0;
        int highestNum = 0;
        int lowestNum = 65536;
        int currentNum = 0;
        int numToSave = 0;

        while ((line = br.readLine()) != null) {

            highestNum = 0;
            lowestNum = 65536;

            String[] splitString= line.split("\t");

            for (int i = 0; i < splitString.length; i++){
                currentNum = Integer.parseInt(splitString[i]);
                //println("Current Number: " + currentNum);
                //println("Previous Number: " + prevNum);
                if(currentNum > highestNum) {
                    //println("Number is higher. Saving");
                    highestNum = currentNum;
                }
                if(currentNum < lowestNum) {
                    //println("Number is lower. Saving");
                    lowestNum = currentNum;
                }
                //prevNum = currentNum;
            }
            println("The highest number in this row is: " + highestNum);
            println("The lowest number in this row is: " + lowestNum);

            numToSave = highestNum-lowestNum;
            finalAnswer = finalAnswer + numToSave;

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

