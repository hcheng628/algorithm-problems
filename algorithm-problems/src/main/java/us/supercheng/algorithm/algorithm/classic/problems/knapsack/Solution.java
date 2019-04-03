package us.supercheng.algorithm.algorithm.classic.problems.knapsack;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] weights = {2, 1, 3},
              values = {10, 6, 12};

        for (int capacity=0;capacity<=6;capacity++)
            PrintHelper.echoLn(solution.maxValue(weights, values, capacity));
    }

    public int maxValue(int[] weights, int[] values, int capacity) {
        Integer[][] memo = new Integer [weights.length][capacity+1];
        int resRec = this.maxValueRec(weights, values, weights.length-1, capacity, memo),
            resDP = this.maxValueDP(weights, values, capacity),
            resDPOpt = this.maxValueDPOpt(weights, values, capacity),
            resDPOpt2 = this.maxValueDPOpt2(weights, values, capacity);

        if (resRec != resDP || resDP != resDPOpt || resDPOpt != resDPOpt2)
            throw new RuntimeException("resRec: " + resRec + "\r\nresDP: " + resDP
                    + "\r\nresDPOpt: " + resDPOpt + "\r\nresDPOpt2: " + resDPOpt2);
        return resDPOpt2;
    }

    private int maxValueRec(int[] weights, int[] values, int idx, int capacity, Integer[][] memo) {
        if (idx < 0 || capacity == 0)
            return 0;

        if (memo[idx][capacity] != null)
            return memo[idx][capacity];

        int max = this.maxValueRec(weights, values, idx-1, capacity, memo);

        if (capacity >= weights[idx])
            max = Math.max(values[idx] + this.maxValueRec(weights, values, idx-1, capacity - weights[idx], memo), max);

        memo[idx][capacity] = max;

        return max;
    }

    private int maxValueDP(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length][capacity+1];

        // init 1st row
        for (int i=0;i<=capacity;i++)
            if (weights[0] <= i)
                dp[0][i] = values[0];

        for (int i=1;i<weights.length;i++)
            for (int j=0;j<=capacity;j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= weights[i])
                    dp[i][j] = Math.max(values[i] + dp[i-1][j-weights[i]],dp[i][j]);
            }

        return dp[weights.length-1][capacity];
    }

    private int maxValueDPOpt(int[] weights, int[] values, int capacity) {
        int [][] dp = new int[2][capacity+1];

        for (int i=0;i<=capacity;i++)
            if (weights[0] <= i)
                dp[0][i] = values[0];

        for (int i=1;i<weights.length;i++)
            for (int j=0;j<=capacity;j++) {
                int idx = i%2, prev = (i-1)%2;
                dp[idx][j] = dp [prev][j];
                if (weights[i] <= j)
                    dp[idx][j] = Math.max(values[i] + dp[prev][j-weights[i]], dp[idx][j]);
            }
        return dp[(weights.length-1) % 2][capacity];
    }

    private int maxValueDPOpt2(int[] weights, int[] values, int capacity) {
        int[] dp = new int [capacity+1];
        int lastRow = weights.length-1;
        // init 1st row
        for (int i=0;i<=capacity;i++)
            if(weights[0] <= i)
                dp[i] = values[0];

        for (int i=1;i<weights.length;i++)
            for (int j=capacity;j>-1&&weights[i]<=j;j--) {
                if (weights[i]<=j)
                    dp[j] = Math.max(values[i] + dp[j-weights[i]], dp[j]);
                if (i == lastRow)
                    break;
            }
        return dp[capacity];
    }

    private void printDPArray(int[][] arr) {
        for (int [] row : arr) {
            for (int each : row)
                PrintHelper.echo(each + ", ");
            PrintHelper.echoLn();
        }
    }
}