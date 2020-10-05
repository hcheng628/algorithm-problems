package us.supercheng.algorithm.problems.maximumsumcircularsubarray;

public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int max = A[0],
                curr_max = max,
                total = max,
                min = max,
                curr_min = max;

        for (int i=1, len=A.length; i<len; i++) {
            int curr = A[i];
            curr_max = Math.max(curr + curr_max, curr);
            max = Math.max(curr_max, max);
            curr_min = Math.min(curr + curr_min, curr);
            min = Math.min(curr_min, min);
            total += curr;
        }

        return total == min ? max : Math.max(max, total - min);
    }
}