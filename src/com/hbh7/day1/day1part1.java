package com.hbh7.day1;

import java.io.*;

public class day1part1 {

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
        boolean matched = false;


        while ((line = br.readLine()) != null && !done) {

            for (int i = 0; i < line.length(); i++){
                System.out.println("----------");
                if(i == line.length()) {
                    currentNum = firstNum;
                } else {
                    char c = line.charAt(i);
                    currentNum = Character.getNumericValue(c);

                    if (i != (line.length() - 1)) {
                        char cc = line.charAt(i + 1);
                        nextNum = Character.getNumericValue(cc);
                    } else {
                        nextNum = firstNum;
                    }

                }

                System.out.println("Current Number: " + currentNum);
                System.out.println("Next Number: " + nextNum);
                System.out.println("Current Position: " + i);

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
}

