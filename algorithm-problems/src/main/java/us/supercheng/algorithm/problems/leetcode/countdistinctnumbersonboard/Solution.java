package us.supercheng.algorithm.problems.leetcode.countdistinctnumbersonboard;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int distinctIntegers(int n) {
        return this.helper(new HashSet<>(), n);
    }

    private int helper(Set<Integer> set, int n) {
        if (set.contains(n))
            return set.size();

        set.add(n);
        for (int i = n - 1; i > 1; i--)
            if (n % i == 1)
                this.helper(set, i);

        return set.size();
    }

}
