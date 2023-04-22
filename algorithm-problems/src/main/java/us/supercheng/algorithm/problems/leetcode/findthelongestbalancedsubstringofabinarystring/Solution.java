package us.supercheng.algorithm.problems.leetcode.findthelongestbalancedsubstringofabinarystring;

class Solution {

    public int findTheLongestBalancedSubstring(String s) {
        if (s == null)
            return 0;

        int ret = 0;

        for (int i = 0, stack = 0, len = s.length(); i < len; stack = 0) {
            for (;i < len && s.charAt(i) == '0'; i++)
                stack++;

            if (stack == 0)
                i++;
            else {
                int curr = 0;
                for (;stack > 0 && i < len && s.charAt(i) == '1'; stack--, i++)
                    curr += 2;
                ret = Math.max(curr, ret);
            }
        }

        return ret;
    }

}
