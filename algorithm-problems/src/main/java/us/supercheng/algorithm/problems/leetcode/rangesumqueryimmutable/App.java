package us.supercheng.algorithm.problems.leetcode.rangesumqueryimmutable;

public class App {

    private int[] nums;
    private int[] dp;

    public App(int[] nums) {
        this.nums = nums;
        if(nums.length > 0) {
            this.dp = new int [nums.length];
            this.dp[0] = nums[0];
            for(int i=1;i<nums.length;i++)
                this.dp[i] = this.dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(this.nums == null || this.nums.length < 1)
            return 0;
        if(i==j)
            return this.nums[i];
        return i == 0 ? this.dp[j] : this.dp[j] - this.dp[i-1];
    }
}
