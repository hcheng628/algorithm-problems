package us.supercheng.algorithm.problems.leetcode.minimumcommonvalue;

class Solution {

    public int getCommon(int[] nums1, int[] nums2) {
        for (int idx1 = 0, idx2 = 0; idx1 < nums1.length && idx2 < nums2.length; )
            if (nums1[idx1] == nums2[idx2])
                return nums1[idx1];
            else if (nums1[idx1] < nums2[idx2])
                idx1++;
            else
                idx2++;

        return -1;
    }

}
