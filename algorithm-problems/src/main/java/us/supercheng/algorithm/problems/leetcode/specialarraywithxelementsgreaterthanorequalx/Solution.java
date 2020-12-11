package us.supercheng.algorithm.problems.leetcode.specialarraywithxelementsgreaterthanorequalx;

public class Solution {

    public int specialArray(int[] nums) {
        int[] bucket = new int[1001];
        for (int n : nums)
            bucket[n]++;

        for (int i=1, len = nums.length; i<=len; i++)
            if (this.getCount(nums, len, bucket, i) == i)
                return i;

        return -1;
    }

    private int getCount(int[] nums, int len, int[] bucket, int val) {
        int ret = 0;

        for (int i=val; i<=1000; i++) {
            ret += bucket[i];
            if (ret > val || ret > len)
                return -1;
        }

        return val == ret ? val : -1;
    }

    public int specialArrayOpt(int[] nums) {
        for (int L = nums.length, len = L; len > 0; len--) {
            int count = 0;
            for (int i=0; i<L && count <= len; i++)
                if (nums[i] >= len)
                    count++;

            if (count == len)
                return len;
        }

        return -1;
    }
}