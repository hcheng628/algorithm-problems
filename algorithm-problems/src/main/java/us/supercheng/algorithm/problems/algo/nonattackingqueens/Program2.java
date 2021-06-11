package us.supercheng.algorithm.problems.algo.nonattackingqueens;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Program2 {

    // Time: O(n!)  Space: O(n)
    public int nonAttackingQueens(int n) {
        Integer[] res = new Integer[n];
        return this.helper(n, res, new HashSet<>(), new HashSet<>(), 0);
    }

    private int helper(int n, Integer[] res, Set<Integer> rSet, Set<Integer> cSet, int row) {
        if (row >= n)
            return 1;

        int ret = 0;

        for (int col = 0; col < n; col++)
            if (!cSet.contains(col) && this.isDia(n, res, row, col)) {
                rSet.add(row);
                cSet.add(col);
                res[row] = col;
                ret += this.helper(n, res, rSet, cSet, row + 1);
                rSet.remove(row);
                cSet.remove(col);
                res[row] = null;
            }

        return ret;
    }

    // Time: O(n)
    private boolean isDia(int n, Integer[] res, int r, int c) {
        int downVal = r - c;
        int upVal = r + c;

        for (int row=0; row<n; row++) {
            Integer col = res[row];
            if (col == null)
                continue;
            if (downVal == row - col || upVal == row + col)
                return false;
        }

        return true;
    }

}
