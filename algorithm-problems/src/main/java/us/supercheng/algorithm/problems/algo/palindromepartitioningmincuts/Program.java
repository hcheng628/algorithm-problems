package us.supercheng.algorithm.problems.algo.palindromepartitioningmincuts;

import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        String s = "noonabbad";
        System.err.println(Program.palindromePartitioningMinCuts(s));
    }

    public static int palindromePartitioningMinCuts(String str) {
        return helper(str, new HashMap<>());
    }

    private static int helper(String s, Map<String, Integer> memo) {
        int len = s.length();
        if (len < 2 || isP(s))
            return 0;
        else if (memo.containsKey(s))
            return memo.get(s);

        Integer ret = null;

        for (int i=0; i<len - 1; i++) {
            int res = helper(s.substring(0, i + 1), memo) + helper(s.substring(i + 1, len), memo) + 1;
            if (ret == null || res < ret)
                ret = res;
        }

        memo.put(s, ret);
        return ret;
    }

    private static boolean isP(String s) {
        for (int left = 0, right = s.length() - 1; left < right; )
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        return true;
    }

    // Time: O(n^2) Space: O(n^2)
    public static int palindromePartitioningMinCuts_Solution2(String str) {
        int len = str.length();
        int[] dp = new int[len];
        Boolean[][] pMat = new Boolean[len][len];

        for (int i=0; i<len; i++)
            pMat[i][i] = true;

        for (int currLen=2; currLen<=len; currLen++)
            for (int i=0; i<=len-currLen; i++)
                if (currLen == 2)
                    pMat[i][i + currLen - 1] = str.charAt(i) == str.charAt(i + currLen - 1);
                else
                    pMat[i][i + currLen - 1] = pMat[i + 1][i + currLen - 2] && str.charAt(i) == str.charAt(i + currLen - 1);

        for (int i=0; i<len; i++) {
            if (i != 0)
                dp[i] = dp[i - 1] + 1;
            for (int prev=i-1; prev>-1; prev--)
                if (pMat[prev][i])
                    dp[i] = prev - 1 > -1 ? Math.min(dp[prev - 1] + 1, dp[i]) : 0;
        }

        return dp[len - 1];
    }
}
