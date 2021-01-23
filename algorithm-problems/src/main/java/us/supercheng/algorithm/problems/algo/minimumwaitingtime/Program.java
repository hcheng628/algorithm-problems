package us.supercheng.algorithm.problems.algo.minimumwaitingtime;

import java.util.*;

public class Program {

    // Time: O(nlog(n)) Space: O(1)
    public int minimumWaitingTime_Solution1(int[] queries) {
        int ret = 0;
        Arrays.sort(queries);

        for (int i=0, curr=0, len=queries.length - 1; i<len; i++) {
            curr += queries[i];
            ret += curr;
        }

        return ret;
    }

    // Time: O(nlog(n)) Space: O(1)
    public int minimumWaitingTime_Solution2(int[] queries) {
        int ret = 0;
        Arrays.sort(queries);

        for (int i=0, len=queries.length; i<len; i++)
            ret += (len - i - 1) * queries[i];

        return ret;
    }

}
