package us.supercheng.algorithm.problems.uniquebinarysearchtrees;

public class App {
    public int numTreesMathDec(int n) {
        double top = 1.0, count = n;

        for(int i=n*2;i>=n+2;i--) {
            top *= i;
            if(i % 2 == 0)
                top /=count--;
        }

        for(;count >= 2;top /=count--);
        return (int) top;
    }

    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            for(int j=0;j<i;j++)
                dp[i] += dp[j] * dp[(i-j-1)];
        return dp[n];
    }
}
