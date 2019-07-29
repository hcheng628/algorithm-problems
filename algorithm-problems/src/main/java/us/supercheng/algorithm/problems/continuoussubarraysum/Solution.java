package us.supercheng.algorithm.problems.continuoussubarraysum;

class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null)
            return false;

        int len = nums.length;
        int[] mat = new int [len];
        for (int i=0;i<len;i++) {
            mat[i] = nums[i];
            for (int j=i+1;j<len;j++) {
                mat[j] = nums[j] + mat[j-1];
                if ((k==0 && mat[j-1] == 0 && mat[j] == 0) || (k != 0 && mat[j] % k == 0))
                    return true;
            }
        }
        return false;
    }
}