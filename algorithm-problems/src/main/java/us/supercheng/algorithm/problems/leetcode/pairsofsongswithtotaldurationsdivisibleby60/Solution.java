package us.supercheng.algorithm.problems.leetcode.pairsofsongswithtotaldurationsdivisibleby60;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ret = 0;
        int[] minsCount = new int [61];

        for (int each : time) {
            int mod = each % 60;
            if (mod == 0) {
                ret += minsCount[0];
                minsCount[0]++;
            } else {
                ret += minsCount[60 - mod];
                minsCount[mod]++;
            }
        }

        return ret;
    }
}