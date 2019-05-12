package us.supercheng.algorithm.problems.twocityscheduling;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int twoCitySchedCost(int[][] costs) {
        int ret = 0,
                siteCount = costs.length/2;

        Arrays.sort(costs, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });

        for (int i=0;i<costs.length;i++)
            ret += i < siteCount ? costs[i][1] : costs[i][0];
        return ret;
    }
}