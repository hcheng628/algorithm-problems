package us.supercheng.algorithm.problems.mincostclimbingstairs;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int [] cost = {0,1,1,1,0,0,1};
        PrintHelper.echoLn(new App().minCostClimbingStairs(cost));
        PrintHelper.echoLn(new App().minCostClimbingStairs1(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int [cost.length+1];
        for(int i=2;i<dp.length;i++)
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        return dp[cost.length];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int prev=0, prevPrev=0;
        for(int i=cost.length-1;i>=0;i--) {
            int cur = cost[i] + Math.min(prev, prevPrev);
            prevPrev = prev;
            prev = cur;
        }
        return Math.min(prevPrev, prev);
    }
}
