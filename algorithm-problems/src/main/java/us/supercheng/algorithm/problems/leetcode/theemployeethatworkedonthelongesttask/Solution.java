package us.supercheng.algorithm.problems.leetcode.theemployeethatworkedonthelongesttask;

class Solution {

    public int hardestWorker(int n, int[][] logs) {
        int[] info = new int[]{logs[0][0], logs[0][1]};

        for (int i = 1, len = logs.length; i < len; i++)
            if (info[1] < logs[i][1] - logs[i - 1][1] || (info[1] == logs[i][1] - logs[i - 1][1] && logs[i][0] < info[0]))
                info = new int[]{logs[i][0], logs[i][1] - logs[i - 1][1]};

        return info[0];
    }

}
