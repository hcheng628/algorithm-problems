package us.supercheng.algorithm.problems.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        this.helper(ret, new ArrayList(), 1, n, k);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> list, int i, int n, int k) {
        if(list.size() == k)
            ret.add(new ArrayList<>(list));
        else {
            int end = n - k + list.size() + 1;
            for(;i<=end;i++) {
                list.add(i);
                this.helper(ret, list, i+1, n, k);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n)
            return ret;
        this.dfs(ret, n, k, new ArrayList<>(), 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int n, int k, List<Integer> list, int idx) {
        if (k == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i=1;i<=n;i++)
            if (i > idx) {
                list.add(i);
                this.dfs(ret, n, k-1, list, i);
                list.remove(list.size()-1);
            }
    }
}
