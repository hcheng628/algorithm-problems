package us.supercheng.algorithm.problems.predictthewinner;

class Solution {

    public boolean PredictTheWinner(int[] nums) {
        return nums == null || nums.length < 2 || this.doPredict(nums, 0, nums.length-1, 0, true) >= 0;
    }

    private int doPredict(int[] nums, int left, int right, int curr, boolean isP1) {
        if (left == right)
            return curr;

        return isP1 ? Math.max(this.doPredict(nums, left+1, right, curr + nums[left], !isP1),
                this.doPredict(nums, left, right-1, curr + nums[right], !isP1)) :
                Math.min(this.doPredict(nums, left+1, right, curr - nums[left], !isP1),
                        this.doPredict(nums, left, right-1, curr - nums[right], !isP1));
    }
}