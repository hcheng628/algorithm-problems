package us.supercheng.algorithm.problems.combinations;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        this.helper(ret, new ArrayList<>(), 1, n, k);
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
}
