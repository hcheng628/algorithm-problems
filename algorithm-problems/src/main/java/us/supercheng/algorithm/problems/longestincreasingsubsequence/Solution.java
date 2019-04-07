package us.supercheng.algorithm.problems.longestincreasingsubsequence;

class Solution {

    Integer [] memo;
    int max = 1;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        this.memo = new Integer[nums.length];
        this.memo[0] = 1;   // Rec-Func Ret Condition
        this.lisHelper(nums, nums.length-1);

        return this.max;
    }

    private int lisHelper(int[] nums, int idx) {
        if (this.memo[idx] != null)
            return this.memo[idx];

        int ret = 1;

        for (int idxCopy =idx;idxCopy-1 > -1;idxCopy--) {
            int res = this.lisHelper(nums, idxCopy-1) + 1;
            if (nums[idxCopy-1] < nums[idx] && res > ret)
                ret = res;
        }

        this.memo[idx] = ret;
        if (this.max < this.memo[idx])
            this.max = this.memo[idx];

        return this.memo[idx];
    }

    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        this.memo = new Integer[nums.length];

        for (int i=0;i<nums.length;i++) {
            memo[i] = 1;
            for (int j=i-1;j>-1;j--)
                if (nums[j] < nums[i] && memo[j] >= memo[i])
                    memo[i] = memo[j]+1;
            if (memo[i] > this.max)
                this.max = memo[i];
        }

        return this.max;
    }
}