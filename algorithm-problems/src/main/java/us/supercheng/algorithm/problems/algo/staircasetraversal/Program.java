package us.supercheng.algorithm.problems.algo.staircasetraversal;

import java.util.*;

public class Program {

    private Integer[] memo;

    public int staircaseTraversal(int height, int maxSteps) {
        this.memo = new Integer[height + 1];
        return this.helper(height, maxSteps, 0);
    }

    private int helper(int height, int maxSteps, int curr) {
        if (this.memo[curr] != null)
            return this.memo[curr];
        else if (curr == height)
            return this.memo[curr] = 1;

        int ret = 0;
        for (int i=1; curr+i <= height && i<=maxSteps; i++)
            ret += this.helper(height, maxSteps, curr + i);

        return this.memo[curr] = ret;
    }
}
