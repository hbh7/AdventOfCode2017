package com.hbh7.day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class day6part2 {

    public static void main(String[] args) throws IOException {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        FileInputStream fis = new FileInputStream("out/production/AdventOfCode2017/com/hbh7/day6/input.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        int position = 0;
        int stepCount = 0;
        int finalAnswer = 0;
        int memoryBankCount = 0;
        int firstRepeatIndex = 0;
        boolean run = true;

        // Find out how many memory banks we need

        line = br.readLine();
        String[] splitString= line.split("\t");
        memoryBankCount = splitString.length;
        System.out.println("memoryBankCount: " + memoryBankCount);

        int[] inputArray = new int[memoryBankCount];
        int[][] previousArrays = new int[65536][memoryBankCount];

        //while ((line = br.readLine()) != null) {
            System.out.println("Line: " + line);

            //String[] splitString= line.split("\t");

            for (int i = 0; i < splitString.length; i++) {
                inputArray[i] = Integer.parseInt(splitString[i]);
            }
        //}
        System.out.println("Original Array: " + Arrays.toString(inputArray));

        int i = 0;
        int prevArrayCounter = 0;

        System.out.println("<INFO> Starting Main Loop");
        mainloop:
        while(run) {

            System.out.println("<INFO> Starting Cycle");

            //Check if array is equal to any previous one
            System.out.println("<INFO> Checking if array is equal to any previous");
            outerloop:
            for(int totalArraysInArrayIterator = 0; totalArraysInArrayIterator < previousArrays.length; totalArraysInArrayIterator++) {
                // Break out if we're testing empty arrays
                int[][] zeroArray = new int[1][memoryBankCount];
                if(Arrays.equals(previousArrays[totalArraysInArrayIterator], zeroArray[0])) {
                    break;
                }

                int matchCount = 0;
                innerloop:
                for (int iterate = 0; iterate < memoryBankCount; iterate++) {
                    if (previousArrays[totalArraysInArrayIterator][iterate] == inputArray[iterate]) {
                        //System.out.println("Checking Position: " + iterate);
                        //System.out.println("Previous Array Value: " + previousArrays[totalArraysInArrayIterator][iterate]);
                        //System.out.println("Current Array Value: " + inputArray[iterate]);
                        matchCount++;
                    }
                }

                //System.out.println("Old Array: " + Arrays.toString(previousArrays[totalArraysInArrayIterator]));
                //System.out.println("Current Array: " + Arrays.toString(inputArray));

                if (matchCount == memoryBankCount) {
                    System.out.println("Found a match on an old array. Repeat detected!");
                    run = false;
                    firstRepeatIndex = totalArraysInArrayIterator;
                    break mainloop;
                } else {
                    //System.out.println("Did not find a match on current old array.");
                }

            }

            System.out.println("<INFO> Storing Array");
            // Store previous array
            for(int iterate = 0; iterate < memoryBankCount; iterate++) {
                previousArrays[prevArrayCounter][iterate] = inputArray[iterate];
            }
            prevArrayCounter++;

            // Iterate final answer (number of cycles)
            finalAnswer++;

            System.out.println("<INFO> Updating Array");
            // Find position with highest number to empty
            int arrayPosToEmpty = 0;
            int highestNumberValue = 0;
            int highestNumberIndex = 0;
            for(int k = 0; k < memoryBankCount; k++) {
                if(inputArray[k] > highestNumberValue) {
                    highestNumberValue = inputArray[k];
                    highestNumberIndex = k;
                }
            }
            int numsToDistribute = inputArray[highestNumberIndex];
            if(numsToDistribute != highestNumberValue) {
                System.err.println("Fatal Error. numToDistribute != highestNumberValue!");
                break;
            }
            System.out.println("Distribute " + numsToDistribute + " from array index " + highestNumberIndex);

            //System.out.println("Old Array: " + Arrays.toString(inputArray));

            // Reset old position
            inputArray[highestNumberIndex] = 0;

            // Distribute numbers
            boolean firstRun = true;
            int startIndex = (highestNumberIndex+1);
            if(startIndex > (memoryBankCount-1))
                startIndex = 0;
            while(numsToDistribute > 0) {
                if(firstRun){
                    for (int k = startIndex; k < (memoryBankCount); k++) {
                        if(numsToDistribute > 0) {
                            inputArray[k] = inputArray[k] + 1;
                            numsToDistribute--;
                        }
                    }
                    firstRun = false;
                } else {
                    for (int k = 0; k < (memoryBankCount); k++) {
                        if(numsToDistribute > 0) {
                            inputArray[k] = inputArray[k] + 1;
                            numsToDistribute--;
                        }
                    }
                }
            }

            System.out.println("New Array: " + Arrays.toString(inputArray));
            System.out.println("<INFO> Done updating array");

            /*
            if(i == (memoryBankCount-1)) {
                i = 0;
            } else {
                i++;
            }
            */


            System.out.println("<INFO> Cycle complete");
        }

        finalAnswer = finalAnswer - firstRepeatIndex;

        System.out.println("----------");
        System.out.println("Final Answer: " + finalAnswer);

        br.close();
    }

}

