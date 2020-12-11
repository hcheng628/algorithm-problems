package us.supercheng.algorithm.problems.leetcode.numberoflongestincreasingsubsequence;

class Solution {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int len = nums.length,
                max = 1,
                ret = 0;

        int[] arrLen = new int[len],
                arrOcc = new int[len];

        for (int i=0;i<len;i++) {
            arrLen[i] = arrOcc[i] = 1;
            for (int j=0;j<i;j++) {
                if (nums[i] <= nums[j])
                    continue;

                int curr = arrLen[j] + 1;
                max = Math.max(max, Math.max(curr, arrLen[i]));
                if (curr > arrLen[i]) {
                    arrLen[i] = curr;
                    arrOcc[i] = arrOcc[j];
                } else if (curr == arrLen[i])
                    arrOcc[i] += arrOcc[j];
            }
        }

        for (int i=0;i<len;i++)
            if (arrLen[i] == max)
                ret += arrOcc[i];

        return ret;
    }
}