package us.supercheng.algorithm.problems.leetcode.countasterisks;

class Solution {

    public int countAsterisks(String s) {
        int ret = 0;
        int count = 0;

        for (char c : s.toCharArray())
            if (c == '|')
                count++;
            else if (c == '*' && count % 2 == 0)
                ret++;

        return ret;
    }

}
