package us.supercheng.algorithm.problems.leetcode.substringsofsizethreewithdistinctcharacters;

public class Solution {

    public int countGoodSubstrings(String s) {
        int ret = 0;

        for (int left=0, right=0, len=s.length(); right<len; ) {
            int size = right - left + 1;

            if (size < 3)
                right++;
            else if (size == 3) {
                char a = s.charAt(left);
                char b = s.charAt(left + 1);
                char c = s.charAt(right);

                if (a != b && a != c && b != c)
                    ret++;
                right++;
            } else
                left++;
        }

        return ret;
    }

}
