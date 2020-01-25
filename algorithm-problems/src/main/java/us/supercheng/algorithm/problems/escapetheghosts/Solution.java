package us.supercheng.algorithm.problems.escapetheghosts;

public class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int ret = this.calDis(0, 0, target);
        for (int[] g : ghosts)
            if (this.calDis(g[0], g[1], target) <= ret)
                return false;

        return true;
    }

    private int calDis(int x, int y, int[] target) {
        return Math.abs(x-target[0]) + Math.abs(y-target[1]);
    }
}