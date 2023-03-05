package us.supercheng.algorithm.problems.leetcode.findthearrayconcatenationvalue;

class Solution {

    public long findTheArrayConcVal(int[] nums) {
        long ret = 0;

        for (int left = 0, right = nums.length - 1; left <= right; left++)
            if (left == right)
                ret += nums[left];
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[left]);
                sb.append(nums[right--]);
                ret += Integer.parseInt(sb.toString());
            }

        return ret;
    }

}
