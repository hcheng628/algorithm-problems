package us.supercheng.algorithm.problems.algo.numberofbinarytreetopologies;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n)
    public static int numberOfBinaryTreeTopologies_Solution1(int n) {
        return helper(n, new HashMap<>());
    }

    private static int helper(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            map.put(n, 1);
            return 1;
        }

        if (map.containsKey(n))
            return map.get(n);

        int ret = 0;

        for (int i=0; i<n; i++)
            ret += helper(i, map) * helper(n - i - 1, map);

        map.put(n, ret);
        return ret;
    }
}
