package us.supercheng.algorithm.problems.leetcode.flipstringtomonotoneincreasing;

public class Solution {

    public int minFlipsMonoIncr(String S) {
        int len = S.length(),
                ret = len,
                zeros = 0,
                ones = 0;

        int[] dp0 = new int[len],
              dp1 = new int[len];

        dp0[0] = S.charAt(0) == '0' ? 1 : 0;
        for (int i=1; i<len; i++)
            dp0[i] = dp0[i-1] + (S.charAt(i) == '0' ? 1 : 0);

        dp1[len-1] = S.charAt(len-1) == '1' ? 1 : 0;
        for (int i=len-2; i>-1; i--)
            dp1[i] = dp1[i+1] + (S.charAt(i) == '1' ? 1 : 0);

        for (int i=0; i<len; i++) {
            if (S.charAt(i) == '0')
                zeros++;
            else
                ones++;

            int left = i + 1,
                right = len - left;

            ret = Math.min((left - dp0[i]) + (right - dp1[i]), ret);
        }

        return Math.min(Math.min(len-zeros, len-ones), ret);
    }
}