package us.supercheng.algorithm.problems.minimumsizesubarraysum;

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
}