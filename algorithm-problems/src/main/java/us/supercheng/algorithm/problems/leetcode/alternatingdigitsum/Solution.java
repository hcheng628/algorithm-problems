package us.supercheng.algorithm.problems.leetcode.alternatingdigitsum;

class Solution {

    public int alternateDigitSum(int n) {
        int ret = 0;
        char[] chars = String.valueOf(n).toCharArray();

        for (int i = 0, len = chars.length; i < len; i++)
            ret = ret + (i % 2 == 0 ? chars[i] - '0' : - (chars[i] - '0'));

        return ret;
    }

}
