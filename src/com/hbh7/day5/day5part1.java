package com.hbh7.day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class day5part1 {

    public static void main(String[] args) throws IOException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day5/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int position = 0;
        int stepCount = 0;
        int finalAnswer = 0;

        ArrayList<Integer> inputArrayList = new ArrayList<Integer>();
        while ((line = br.readLine()) != null) {
            inputArrayList.add(Integer.parseInt(line));
        }

        int[] inputArray = new int[inputArrayList.size()];
        int i = 0;
        for (int num : inputArrayList) {
            inputArray[i] = num;
            i++;
        }

        while(true) {
            try {
                //System.out.println(Arrays.toString(inputArray));
                //System.out.println("Step Count: " + stepCount);
                //System.out.println("Position: " + position);

                inputArray[position] = inputArray[position] + 1;

                position = position + inputArray[position] - 1;
                //System.out.println("New Position: " + position);

                stepCount++;



            } catch (IndexOutOfBoundsException e) {
                //System.err.println("IndexOutOfBoundsException: " + e.getMessage());
                break;
            }

        }

        finalAnswer = stepCount;

        System.out.println("----------");
        System.out.println("Final Answer: " + finalAnswer);

        br.close();
    }

}

