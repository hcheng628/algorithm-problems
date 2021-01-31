package us.supercheng.algorithm.problems.algo.minnumberofjumps;

public class Program {

    public static int minNumberOfJumps(int[] array) {
        int len = array.length;
        int[] dp = new int[len];

        for (int i=0; i<len; i++) {
            int amt = dp[i] + 1;
            int dis = array[i] + i + 1;
            for (int j=i+1; j<len && j<dis; j++)
                dp[j] = dp[j] == 0 ? amt : Math.min(amt, dp[j]);
        }

        return dp[len - 1];
    }

}
