package us.supercheng.algorithm.problems.longestmountaininarray;

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
}