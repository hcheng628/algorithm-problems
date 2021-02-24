package us.supercheng.algorithm.problems.algo.numberofwaystotraversegraph;

public class Program {

    int count = 0;

    // Time: O(2^w*h) Space: O(max(w, h))
    public int numberOfWaysToTraverseGraph_Solution1(int width, int height) {
        this.travel(width, height, 0, 0, new boolean[height][width]);
        return this.count;
    }

    private void travel(int width, int height, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= height || col < 0 || col >= width || visited[row][col])
            return;
        else if (row == height - 1 && col == width - 1) {
            this.count++;
            return;
        }

        visited[row][col] = true;
        this.travel(width, height, row + 1, col, visited);
        this.travel(width, height, row, col + 1, visited);
        visited[row][col] = false;
    }

    // Time: O(2^w*h) Space: O(max(w, h))
    public int numberOfWaysToTraverseGraph_Solution2(int width, int height) {
        return width == 1 || height == 1 ? 1 :
                this.numberOfWaysToTraverseGraph_Solution2(width - 1, height) +
                        this.numberOfWaysToTraverseGraph_Solution2(width, height - 1);
    }

    // Time: O(w*h) Space: O(w*h)
    public int numberOfWaysToTraverseGraph_Solution3(int width, int height) {
        if (width == 1 || height == 1)
            return 1;

        int[][] dp = new int[height][width];

        for (int i=0; i<height; i++)
            dp[i][0] = 1;

        for (int i=1; i<width; i++)
            dp[0][i] = 1;

        for (int i=1; i<height; i++) {
            for (int j=1; j<width; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[height - 1][width - 1];
    }
}