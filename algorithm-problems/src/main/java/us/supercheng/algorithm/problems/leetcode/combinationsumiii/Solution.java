package us.supercheng.algorithm.problems.leetcode.combinationsumiii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        this.dfs(ret, new ArrayList<>(), 1, k, n);
        return new ArrayList<>(ret);
    }

    private void dfs(List<List<Integer>> ret, List<Integer> list, int index, int currK, int val) {
        if(val < 0 || currK < 0)
            return;

        if(currK==0 && val == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<=9;i++) {
            list.add(i);
            this.dfs(ret, list, i+1, currK -1,val - i);
            list.remove(list.size()-1);
        }
    }
}