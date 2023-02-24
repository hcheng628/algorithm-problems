package us.supercheng.algorithm.problems.leetcode.largestpositiveintegerthatexistswithitsnegative;

class Solution {

    public int findMaxK(int[] nums) {
        int ret = -1;
        boolean[] count = new boolean[2001];

        for (int n : nums) {
            count[n + 1000] = true;
            if (n < 0) {
                if (count[Math.abs(n) + 1000] && ret < Math.abs(n))
                    ret = Math.abs(n);
            } else {
                if (count[1000 - n] && ret < n)
                    ret = n;
            }
        }

        return ret;
    }

}
