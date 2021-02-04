package us.supercheng.algorithm.problems.algo.validstartingcity;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(1)
    public int validStartingCity_Solution1(int[] distances, int[] fuel, int mpg) {
        for (int i=0, len = distances.length; i<len; i++) {
            int curr = i;
            int leftFuel = 0;
            boolean success = true;
            do {
                leftFuel = mpg * fuel[curr] - distances[curr] + leftFuel;
                if (leftFuel < 0)
                    success = false;
                else {
                    curr++;
                    if (curr == len)
                        curr = 0;
                }
            } while (success && i != curr);

            if (success)
                return i;
        }

        return -1;
    }

    // Time: O(n) Space: O(1)
    public int validStartingCity_Solution2(int[] distances, int[] fuel, int mpg) {
        int ret = 0;

        for (int i=1, min = 0, fuelLeft=0, len = distances.length; i<len; i++) {
            fuelLeft = fuel[i-1] * mpg + fuelLeft - distances[i-1];
            if (fuelLeft < min) {
                min = fuelLeft;
                ret = i;
            }
        }

        return ret;
    }
}
