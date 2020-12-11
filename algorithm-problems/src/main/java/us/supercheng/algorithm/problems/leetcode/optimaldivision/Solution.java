package us.supercheng.algorithm.problems.leetcode.optimaldivision;

class Solution {

    class Result {
        String s;
        Double val;
    }

    public String optimalDivision(int[] nums) {
        Result r = this.max(nums, 0, nums.length-1);
        return r.s;
    }


    private Result max(int[] nums, int left, int right) {
        Result res = new Result();
        if (left == right) {
            res.val = (double) nums[left];
            res.s = Integer.toString(nums[left]);
        } else if (left + 1 == right) {
            res.val = (double)nums[left]/ (double)nums[right];
            res.s = nums[left] + "/" + nums[right];
        } else {
            for (int i=left;i<right;i++) {
                Result leftRes = this.max(nums, left, i),
                        rightRes = this.min(nums, i+1, right);
                double val = leftRes.val / rightRes.val;
                if (res.val == null || val > res.val) {
                    res.val = val;
                    res.s = leftRes.s + "/" + (right - i >= 2 ? "(" + rightRes.s + ")" : rightRes.s);
                }
            }
        }
        return res;
    }

    private Result min(int[] nums, int left, int right) {
        Result res = new Result();

        if (left == right) {
            res.val = (double) nums[left];
            res.s = Integer.toString(nums[left]);
        } else if (left + 1 == right) {
            res.val = (double) nums[left] / (double) nums[right];
            res.s = nums[left] + "/" + nums[right];
        } else {
            for (int i=left;i<right;i++) {
                Result leftRes = this.min(nums, left, i),
                        rightRes = this.max(nums, i+1, right);
                double val = leftRes.val / rightRes.val;
                if (res.val == null || val < res.val) {
                    res.val = val;
                    res.s = leftRes.s + "/" + (right - i >= 2 ? "(" + rightRes.s + ")" : rightRes.s);
                }
            }
        }
        return res;
    }
}