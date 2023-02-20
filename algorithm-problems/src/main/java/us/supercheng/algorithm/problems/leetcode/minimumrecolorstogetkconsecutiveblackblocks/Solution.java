package us.supercheng.algorithm.problems.leetcode.minimumrecolorstogetkconsecutiveblackblocks;

class Solution {

    public int minimumRecolors(String blocks, int k) {
        int ret = k;

        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++)
            ret = Math.min(this.min(chars, k, i), ret);

        return ret;
    }

    private int min(char[] chars, int k, int i) {
        if (i + k > chars.length)
            return k;

        int ret = 0;
        for (int idx = i, count = 0; count < k; idx++, count++)
            if (chars[idx] == 'W')
                ret++;

        return ret;
    }

}