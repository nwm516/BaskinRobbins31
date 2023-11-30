package org.example;

import java.util.HashMap;

public class Main {

    private static HashMap<Integer, Integer> baskinCache = new HashMap<Integer, Integer>();
    public static void main(String[] args) {

        int finalSolutions = baskin(31);
        System.out.printf("Number of possible outcomes for Baskin Robbins 31 game: %,d%n", finalSolutions);

    }

    private static int baskin(int maxValue) {
        return baskin(1, maxValue);
    }

    private static int baskin(int currentNumber, int maxValue) {
        // Establishing possible outcomes integer
        int outcomes = 0;

        // Checking to see if previously calculated and in cache
        if (baskinCache.containsKey(currentNumber)) {
            return baskinCache.get(currentNumber);
        }
        // Base case
        if (currentNumber == maxValue) {
            outcomes = 1;
        }

        /* Loop explores possible outcomes for numbers to be added,
         * adding them to solutions of potential next steps in game */
        for (int addedNum = 1; addedNum <= 3; addedNum++) {
            int next = currentNumber + addedNum;

            if (next <= maxValue) {
                outcomes += baskin(next, maxValue);
            }
        }
        // Storing possible outcomes in baskinCache with currentNumber as key and outcomes as value
        baskinCache.put(currentNumber, outcomes);

        return outcomes;
    }
}
