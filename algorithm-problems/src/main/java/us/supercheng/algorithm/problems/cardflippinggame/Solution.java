package us.supercheng.algorithm.problems.cardflippinggame;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    int ret;

    public int flipgame(int[] fronts, int[] backs) {
        this.ret = 0;
        Set<Integer> set = new HashSet<>();

        for (int i=0, len = fronts.length; i<len; i++)
            if (fronts[i] == backs[i])
                set.add(fronts[i]);

        for (int f : fronts)
            if (!set.contains(f))
                ret = this.ret == 0 ? f : Math.min(this.ret, f);

        for (int b : backs)
            if (!set.contains(b))
                ret = this.ret == 0 ? b : Math.min(this.ret, b);

        // TLE
        //this.helper(fronts, backs, 0);
        return this.ret;
    }

    private void helper(int[] fronts, int[] backs, int idx) {
        if (idx >= fronts.length)
            return;

        if (this.ret == 0) {
            if (this.isValid(fronts, backs, idx))
                this.ret = backs[idx];
            this.helper(fronts, backs, idx+1);
            this.swap(fronts, backs, idx);
            this.helper(fronts, backs, idx+1);
            if (this.isValid(fronts, backs, idx))
                this.ret = this.ret == 0 ? backs[idx] : Math.min(this.ret, backs[idx]);
            this.swap(fronts, backs, idx);
        } else {
            if (this.isValid(fronts, backs, idx))
                this.ret = Math.min(this.ret, backs[idx]);
            this.helper(fronts, backs, idx+1);
            this.swap(fronts, backs, idx);
            this.helper(fronts, backs, idx+1);
            if (this.isValid(fronts, backs, idx))
                this.ret = Math.min(this.ret, backs[idx]);
            this.swap(fronts, backs, idx);
        }
    }

    private boolean isValid(int[] fronts, int[] backs, int idx) {
        for (int f : fronts)
            if (f == backs[idx])
                return false;
        return true;
    }

    private void swap(int[] fronts, int[] backs, int idx) {
        int val = fronts[idx];
        fronts[idx] = backs[idx];
        backs[idx] = val;
    }
}