package us.supercheng.algorithm.problems.leetcode.findthemaximumdivisibilityscore;

class Solution {

    public int maxDivScore(int[] nums, int[] divisors) {
        int[] info = new int[]{divisors[0], 0};

        for (int d : divisors) {
            int count = 0;
            for (int n : nums)
                if (n % d == 0)
                    count++;
            if (info[1] < count || (info[1] == count && d < info[0]))
                info = new int[]{d, count};
        }

        return info[0];
    }

}
