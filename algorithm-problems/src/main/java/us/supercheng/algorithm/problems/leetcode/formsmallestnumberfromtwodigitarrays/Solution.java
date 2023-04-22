package us.supercheng.algorithm.problems.leetcode.formsmallestnumberfromtwodigitarrays;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int min2 = nums2[0];
        boolean[][] m = new boolean[10][2];
        
        for (int n : nums1) {
            m[n][0] = true;
            min1 = Math.min(n, min1);
        }
        
        for (int n : nums2) {
            m[n][1] = true;
            min2 = Math.min(n, min2);
        }

        for (int i = 1; i < 10; i++)
            if (m[i][0] && m[i][1])
                return i;

        return Math.min(min1 * 10 + min2, min2 * 10 + min1);
    }
    
}
