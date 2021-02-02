package us.supercheng.algorithm.problems.algo.minnumberofjumps;

public class Program {

    public static int minNumberOfJumps_Solution1(int[] array) {
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

    public static int minNumberOfJumps_Solution2(int[] array) {
        if (array == null || array.length < 2)
            return 0;

        int maxReachIdx = array[0];
        int steps = array[0];
        int jumps = 0;

        for (int i=1, len=array.length; maxReachIdx<len-1 && i<len-1; i++) {
            maxReachIdx = Math.max(array[i] + i, maxReachIdx);
            if (maxReachIdx >= len - 1)  {
                jumps++;
                break;
            }

            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReachIdx - i;
            }
        }

        return jumps + 1;
    }

}
