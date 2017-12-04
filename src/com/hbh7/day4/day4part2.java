package com.hbh7.day4;

import java.io.*;
import java.util.*;

public class day4part2 {

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
            println("Line: " + line);
            String[] splitString = line.split(" ");
            boolean stopSearch = false;

            for (int i = 0; i < splitString.length; i++) {
                currentWord = splitString[i];
                for (int k = 0; k < splitString.length; k++) {
                    nextWord = splitString[k];
                    // Check for duplicate words
                    if (currentWord.equals(nextWord) && i != k && stopSearch == false) {
                        println("Found matching words at position " + i + " and " + k);
                        invalidCount++;
                        stopSearch = true;
                    }
                    // Check for anagrams

                    currentWord = reverseString(currentWord);
                    nextWord = reverseString(nextWord);

                    if (currentWord.equals(nextWord) && i != k && stopSearch == false) {
                        println("Found anagram words at position " + i + " and " + k);
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
    
    public static String reverseString(String str) {
        // put the characters into an array
        Character[] chars2 = new Character[str.length()];
        for (int i2 = 0; i2 < chars2.length; i2++)
            chars2[i2] = str.charAt(i2);

        // sort the array
        Arrays.sort(chars2, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                int cmp = Character.compare(
                        Character.toLowerCase(c1.charValue()),
                        Character.toLowerCase(c2.charValue())
                );
                if (cmp != 0) return cmp;
                return Character.compare(c1.charValue(), c2.charValue());
            }
        });

        // rebuild the string
        StringBuilder sb2 = new StringBuilder(chars2.length);
        for (char c : chars2) sb2.append(c);
        str = sb2.toString();

        return str;
    }

}

