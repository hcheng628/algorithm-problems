package us.supercheng.algorithm.problems.randomflipmatrix;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Solution {

    int ROW;
    int COL;
    int MAX;
    Set<Integer> set;
    Random rand;

    public Solution(int n_rows, int n_cols) {
        this.rand = new Random();
        this.ROW = n_rows;
        this.COL = n_cols;
        this.MAX = n_rows * n_cols;
        this.set = new HashSet<>();
    }

    public int[] flip() {
        int idx = 0;
        do {
            idx = this.rand.nextInt(MAX);
        } while (set.contains(idx));
        set.add(idx);
        return new int[] {idx / this.COL, idx % this.COL};
    }

    public void reset() {
        this.set.clear();
    }
}