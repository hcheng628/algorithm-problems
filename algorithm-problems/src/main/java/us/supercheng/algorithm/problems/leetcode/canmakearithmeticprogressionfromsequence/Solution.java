package us.supercheng.algorithm.problems.leetcode.canmakearithmeticprogressionfromsequence;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null)
            return true;

        int len = arr.length;

        if (len < 3)
            return true;

        Arrays.sort(arr);
        for (int i = 2, diff = arr[1] - arr[0]; i < len; i++)
            if (arr[i] - arr[i - 1] != diff)
                return false;

        return true;
    }
}
