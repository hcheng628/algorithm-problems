package us.supercheng.algorithm.problems.leetcode.playwithchips;

class Solution {

    public int minCostToMoveChips(int[] chips) {
        int oddMove = 0,
            evenMove = 0;

        for (int chip : chips)
            if (chip % 2 == 0)
                evenMove++;
            else
                oddMove++;
        return Math.min(oddMove, evenMove);
    }
}