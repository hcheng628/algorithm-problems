package us.supercheng.algorithm.problems.leetcode.findthetownjudge;

class Solution {
    public int findJudge(int N, int[][] trust) {
        int [] votes = new int [N+1],
                receives = new int [votes.length];

        for (int [] each : trust) {
            votes[each[0]]++;
            receives[each[1]]++;
        }

        for (int i=1;i<votes.length;i++)
            if (receives[i] == N-1 && votes[i] == 0)
                return i;
        return -1;
    }
}