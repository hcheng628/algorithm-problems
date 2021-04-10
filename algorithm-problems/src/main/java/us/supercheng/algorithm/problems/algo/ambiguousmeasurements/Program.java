package us.supercheng.algorithm.problems.algo.ambiguousmeasurements;

import java.util.*;

public class Program {

    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        return this.helper(measuringCups, low, high, new HashMap<>());
    }

    private boolean helper(int[][] cups, int low, int high, Map<String, Boolean> memo) {
        String key = low + "," + high;

        if (memo.containsKey(key))
            return memo.get(key);

        for (int[] cup : cups) {
            if (cup[0] >= low && cup[1] <= high)
                return true;

            int newLow = low - cup[0];
            int newHigh = high - cup[1];
            if (newLow > 0 && newHigh > 0 && this.helper(cups, newLow, newHigh, memo))
                return true;
        }

        memo.put(key, false);
        return false;
    }

}