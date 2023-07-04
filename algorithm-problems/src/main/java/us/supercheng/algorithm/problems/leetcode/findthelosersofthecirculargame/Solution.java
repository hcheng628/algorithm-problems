package us.supercheng.algorithm.problems.leetcode.findthelosersofthecirculargame;

class Solution {

    public int[] circularGameLosers(int n, int k) {
        int round = 1;
        boolean[] visited = new boolean[n];

        for (int idx = 0; !visited[idx] ; idx = (idx + round++ * k) % n)
            visited[idx] = true;

        int[] ret = new int[n - round + 1];
        for (int i = 0, j = 0; i < n; i++)
            if (!visited[i])
                ret[j++] = i + 1;

        return ret;
    }

}