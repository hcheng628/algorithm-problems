package us.supercheng.algorithm.problems.beautifularray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] beautifulArray(int N) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        int[] ret = new int[N];

        while (l.size() != N) {
            List<Integer> temp = new ArrayList<>();

            for (int ll : l)
                if (ll * 2 <= N)
                    temp.add(ll * 2);

            for (int ll : l)
                if (ll * 2 - 1 <= N)
                    temp.add(ll * 2 - 1);

            l = temp;
        }

        return l.stream().mapToInt(i -> i).toArray();
    }

    // TLE
    List<Integer> ans;

    public int[] beautifulArrayTLE(int N) {
        int[] r = new int[N];
        this.helper(N, new ArrayList<>(), new HashSet<>());

        for (int i=0;i<N;i++)
            r[i] = this.ans.get(i);

        return r;
    }

    private void helper(int N, List<Integer> list, Set<Integer> set) {
        if (this.ans != null)
            return;

        if (list.size() == N) {
            if (this.check(list))
                ans = new ArrayList<>(list);
            return;
        }

        for (int i=1; i<=N; i++)
            if (!set.contains(i)) {
                list.add(i);
                set.add(i);
                this.helper(N, list, set);
                set.remove(i);
                list.remove(list.size()-1);
            }
    }

    private boolean check(List<Integer> list) {
        for (int i=0, len = list.size();i<len-2;i++)
            for (int k=i+1;k<len-1;k++)
                for (int j=k+1;j<len;j++)
                    if (list.get(k) * 2 == list.get(i) + list.get(j))
                        return false;

        return true;
    }
}
