package us.supercheng.algorithm.problems.leetcode.longestmountaininarray;

public class Solution {

    public int longestMountain(int[] A) {
        if (A.length < 3)
            return 0;

        int ret = 0;

        for (int i=0;i<A.length;i++) {
            int left = i-1;
            boolean hasPattern = false;

            for (; left > -1; left--)
                if (A[left] < A[left+1]) {
                    if (!hasPattern)
                        hasPattern = true;
                } else
                    break;

            if (!hasPattern)
                continue;

            int right = i + 1;
            hasPattern = false;

            for (; right<A.length; right++)
                if (A[right] < A[right-1]) {
                    if (!hasPattern)
                        hasPattern = true;
                } else
                    break;

            if (hasPattern)
                ret = Math.max(right - left - 1, ret);
        }

        return ret;
    }

    public int longestMountainBigO_N(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int left = 0,
                ret = 0;
        boolean hasInc = A[0] < A[1],
                hasDec = false;

        for (int i=1; i<A.length; i++)
            if (A[i-1] < A[i]) {
                if (hasInc && hasDec) {
                    hasDec = false;
                    left = i-1;
                } else if (!hasInc && !hasDec)
                    hasInc = true;
                else if (!hasInc) {
                    hasInc = true;
                    hasDec = false;
                    left = i;
                }
            } else if (A[i-1] == A[i]) {
                hasInc = false;
                hasDec = false;
                left = i;
            } else {
                if (hasInc && hasDec) {
                    if (i - left + 1 >= 3)
                        ret = Math.max(ret, i - left + 1);
                } else if (hasInc) {
                    if (i - left + 1 >= 3)
                        ret = Math.max(ret, i - left + 1);
                    hasDec = true;
                } else {
                    if (hasDec)
                        hasDec = false;
                    left = i;
                }
            }

        return ret;
    }
}