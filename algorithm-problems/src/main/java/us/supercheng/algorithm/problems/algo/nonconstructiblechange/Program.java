package us.supercheng.algorithm.problems.algo.nonconstructiblechange;

import java.util.*;

public class Program {

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int sum = 0;

        for (int c : coins) {
            if (sum + 1 < c)
                break;
            sum += c;
        }

        return sum + 1;
    }

}