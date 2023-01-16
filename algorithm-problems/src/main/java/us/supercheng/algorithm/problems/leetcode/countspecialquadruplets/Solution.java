package us.supercheng.algorithm.problems.leetcode.countspecialquadruplets;

public class Solution {

    public int countQuadrupletsBF(int[] nums) {
        if (nums == null || nums.length < 4)
            return 0;

        int ret = 0;

        for (int i = 0, len = nums.length; i < len - 3; i++)
            for (int j = i + 1; j < len - 2; j++)
                for (int k = j + 1; k < len - 1; k++)
                    for (int l = k + 1; l < len; l++)
                        if (nums[i] + nums[j] + nums[k] == nums[l])
                            ret++;

        return ret;
    }

    public int countQuadruplets(int[] nums) {
        if (nums == null || nums.length < 4)
            return 0;

        int ret = 0;
        int[] occurrances = new int[201];

        for (int len = nums.length, b = len - 3; b > 0; b--) {
            for (int d = b + 2; d < len; d++)
                if (nums[d] - nums[b + 1] >= 0)
                    occurrances[nums[d] - nums[b + 1]]++;
            for (int a = 0; a < b; a++)
                ret += occurrances[nums[a] + nums[b]];
        }

        return ret;
    }

}
