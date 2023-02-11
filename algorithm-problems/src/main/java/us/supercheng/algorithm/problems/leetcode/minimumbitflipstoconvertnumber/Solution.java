package us.supercheng.algorithm.problems.leetcode.minimumbitflipstoconvertnumber;

class Solution {

    public int minBitFlips(int start, int goal) {
        int ret = 0;
        int diff = start ^ goal;

        for (int i = 0; i < 32; i++)
            if (((1 << i) & diff) != 0)
                ret++;

        return ret;
    }

}
