package com.hbh7.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class day1part2 {

    public static void main(String[] args) throws IOException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day1/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        boolean done = false;

        int firstNum = 0;
        int currentNum = 0;
        int nextNum = 0;
        int storedDigit = 0;
        int finalAnswer =0;
        int matchCount = 0;
        int charPos = 0;
        boolean matched = false;



        while ((line = br.readLine()) != null && !done) {

            for (int i = 0; i < line.length(); i++){
                System.out.println("----------");
                if(i == line.length()) {
                    currentNum = firstNum;
                } else {
                    // Current Position
                    char c = line.charAt(i);
                    currentNum = Character.getNumericValue(c);

                    // Next Position


                    // If its not the last number in the string
                    if (i != (line.length() - 1)) {
                        charPos = i + (line.length() / 2); // 4
                        if(charPos == line.length()){
                            println("charPos equals line.length");
                            charPos = 0;
                        }else if(charPos > line.length()-1) { // 4 > 4-1
                            println("charPos greater than line.length-1");
                            charPos = charPos-(line.length());
                        }

                        char cc = line.charAt(charPos);
                        nextNum = Character.getNumericValue(cc);

                    } else { // If it is the last number in the string
                        println("Last num in string");
                        charPos = (line.length()/2-1);

                        char cc = line.charAt(charPos);
                        nextNum = Character.getNumericValue(cc);
                    }


                }

                System.out.println("Current Number: " + currentNum);
                System.out.println("Next Number: " + nextNum);
                System.out.println("Current Position: " + i);
                System.out.println("Next Position: " + charPos);

                if(i == 0) {
                    firstNum = currentNum;
                }

                if(currentNum == nextNum) {
                    System.out.println("Number matches next");
                    finalAnswer = finalAnswer + currentNum;
                } else {
                    System.out.println("Number does not match next");
                }
                System.out.println("Current Final Answer: " + finalAnswer);

            }

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

