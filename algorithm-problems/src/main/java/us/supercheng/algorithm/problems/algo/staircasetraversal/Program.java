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

    public int staircaseTraversal_Solution2(int height, int maxSteps) {
        int[] dp = new int[height + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=height; i++) {
            int res = 0;
            for (int j=0, ii=i - 1; ii > -1 && j<maxSteps; j++)
                res += dp[ii--];
            dp[i] = res;
        }

        return dp[height];
    }

    public int staircaseTraversal_Solution3(int height, int maxSteps) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i=1, win = 0; i<=height; i++) {
            int startIdx = i - maxSteps - 1;
            int endIdx = i - 1;

            if (startIdx >= 0)
                win -= list.get(startIdx);

            win += list.get(endIdx);
            list.add(win);
        }

        return list.get(height);
    }
}
