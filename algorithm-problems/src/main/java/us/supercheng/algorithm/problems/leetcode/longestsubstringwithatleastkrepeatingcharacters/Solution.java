package us.supercheng.algorithm.problems.leetcode.longestsubstringwithatleastkrepeatingcharacters;

class Solution {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        return this.helper(s.toCharArray(), 0, s.length(), k);
    }

    private int helper(char[] arr, int start, int end, int k) {
        if (end - start < k)
            return 0;
        int[] count = new int [26];

        for (int i=start;i<end;i++)
            count[arr[i] - 'a']++;

        for (int i=start;i<end;i++)
            if (count[arr[i] - 'a'] < k)
                return Math.max(this.helper(arr, start, i, k), this.helper(arr, i+1, end,k));

        return end - start;
    }
}