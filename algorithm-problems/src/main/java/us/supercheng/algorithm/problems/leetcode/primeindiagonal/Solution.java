package us.supercheng.algorithm.problems.leetcode.primeindiagonal;

class Solution {

    public int diagonalPrime(int[][] nums) {
        int ret = 0;
        int len = nums.length;

        for (int r = 0, left = 0, right = len - 1; r <len; r++, left++, right--) {
            if (nums[r][left] > ret && this.isP(nums[r][left]))
                ret = nums[r][left];
            if (nums[r][right] > ret && this.isP(nums[r][right]))
                ret = nums[r][right];
        }
        return ret;
    }

    private boolean isP(int n) {
        if (n < 2)
            return false;
        for(int i = 2, end = (int) Math.sqrt(n); i <= end; i++)
            if(n % i == 0)
                return false;
        return true;
    }

}
