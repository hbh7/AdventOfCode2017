package com.hbh7.day4;

import java.io.*;

public class day4part1 {

    public static void main(String[] args) throws IOException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day4/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;

        int invalidCount = 0;
        int lineCount = 0;
        int finalAnswer = 0;
        String currentWord;
        String nextWord;

        while ((line = br.readLine()) != null) {
            lineCount++;
            println(line);
            String[] splitString = line.split(" ");
            boolean stopSearch = false;

            for (int i = 0; i < splitString.length; i++) {
                currentWord = splitString[i];
                for (int k = 0; k < splitString.length; k++) {
                    nextWord = splitString[k];
                    if (currentWord.equals(nextWord) && i != k && stopSearch == false) {
                        println("Found matching words at position " + i + " and " + k);
                        invalidCount++;
                        stopSearch = true;
                    }
                }
            }
        }

        finalAnswer = lineCount - invalidCount;

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

