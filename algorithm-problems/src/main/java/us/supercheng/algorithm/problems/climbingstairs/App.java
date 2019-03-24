package us.supercheng.algorithm.problems.climbingstairs;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.climbStairs(13));
    }

    public int climbStairs(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

    public int climbStairsDFS(int n) {
        return this.dfs(n, new Integer [n+1]);
    }

    private int dfs(int n, Integer [] count) {
        if (n == 0 || n == 1)
            return 1;

        if (count[n] != null)
            return count[n];

        count[n] = this.dfs(n-1, count) + this.dfs(n-2, count);

        return count[n];
    }
}