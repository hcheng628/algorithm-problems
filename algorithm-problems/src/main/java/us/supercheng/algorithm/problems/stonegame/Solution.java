package us.supercheng.algorithm.problems.stonegame;

public class Solution {

    Boolean[][] memo;

    public boolean stoneGame(int[] piles) {
        this.memo = new Boolean[piles.length+1][piles.length+1];
        return this.helper(piles, 0, 0, 0, piles.length-1, true);
    }

    private boolean helper(int[] p, int alex, int ann, int left, int right, boolean isAlex) {
        if (left > right)
            return alex > ann;

        if (this.memo[left][right] != null)
            return this.memo[left][right];

        boolean res = false;

        if (isAlex)
            res = this.helper(p, alex + p[left], ann, left+1, right, false) ||
                    this.helper(p, alex + p[right], ann, left, right-1, false);
        else
            res = this.helper(p, alex, ann + p[left], left+1, right, true) ||
                    this.helper(p, alex, ann + p[right], left, right -1, true);

        return this.memo[left][right] = res;
    }
}
