package us.supercheng.algorithm.problems.specialarraywithxelementsgreaterthanorequalx;

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
}