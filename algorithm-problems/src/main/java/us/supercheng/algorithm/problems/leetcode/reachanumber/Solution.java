package us.supercheng.algorithm.problems.leetcode.reachanumber;

public class Solution {

    public int reachNumber(int target) {
        if (target < 0)
            target = -target;

        int n = (int) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * target)) / 2),
            sum = (1+n)*n/2,
            res = sum - target;

        if (sum == target || res % 2 == 0)
            return n;
        else
            return n % 2 == 0 ? n + 1 : n + 2;
    }
}