package us.supercheng.algorithm.problems.algo.nonattackingqueens;

import java.util.*;

public class Program2 {

    // Time: O(n!)  Space: O(n)
    public int nonAttackingQueens(int n) {
        Integer[] res = new Integer[n];
        return this.helper(n, res, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
    }

    private int helper(int n, Integer[] res, Set<Integer> cSet, Set<Integer> upSet, Set<Integer> downSet, int row) {
        if (row >= n)
            return 1;

        int ret = 0;

        for (int col = 0; col < n; col++) {
            int upVal = row + col;
            int downVal = row - col;
            if (!cSet.contains(col) && !upSet.contains(upVal) && !downSet.contains(downVal)) {
                cSet.add(col);
                upSet.add(upVal);
                downSet.add(downVal);
                res[row] = col;

                ret += this.helper(n, res, cSet, upSet, downSet, row + 1);

                cSet.remove(col);
                upSet.remove(upVal);
                downSet.remove(downVal);
            }
        }

        return ret;
    }

}
