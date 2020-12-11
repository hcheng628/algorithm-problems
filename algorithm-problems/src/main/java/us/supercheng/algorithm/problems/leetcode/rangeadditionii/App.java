package us.supercheng.algorithm.problems.leetcode.rangeadditionii;

public class App {

    public int maxCount(int m, int n, int[][] ops) {
        int cMin = Integer.MAX_VALUE, rMin = Integer.MAX_VALUE;
        if(ops == null || ops.length == 0)
            return m*n;
        for(int i=0;i<ops.length;i++) {
            cMin = Math.min(cMin, ops[i][0]);
            rMin = Math.min(rMin, ops[i][1]);
        }
        return cMin * rMin;
    }
}