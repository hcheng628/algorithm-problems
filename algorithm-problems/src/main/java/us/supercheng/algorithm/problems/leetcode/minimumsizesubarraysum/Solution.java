package us.supercheng.algorithm.problems.leetcode.minimumsizesubarraysum;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int count = Integer.MAX_VALUE, slow = 0, fast = 0, sum = 0;
        for(;fast<nums.length;fast++) {
            if(nums[fast] >= s)
                return 1;
            for(;fast<nums.length && sum < s;fast++) {
                sum += nums[fast];
                if(sum >= s)
                    break;
            }

            for(;slow<nums.length && sum >= s;slow++) {
                count = Math.min(count, fast - slow + 1);
                sum -= nums[slow];
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;

        int ret = nums.length;
        for(int left=0, right=-1, res = 0;left < nums.length;) {
            if(res >= s) {
                ret = Math.min(ret, right - left);
                res -= nums[left++];
                if (ret == 0)
                    return 1;
            } else {
                if (right + 1 < nums.length)
                    res += nums[++right];
                else
                    left++;
            }
        }

        return ret == nums.length ? 0 : ret+1;
    }
}