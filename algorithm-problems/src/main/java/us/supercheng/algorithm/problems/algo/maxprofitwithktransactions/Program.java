package us.supercheng.algorithm.problems.algo.maxprofitwithktransactions;

public class Program {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 11, 3, 50, 60, 90};
        int res = new Program().maxProfitWithKTransactions(arr, 2);
        System.err.println(res);
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        if (prices == null || prices.length < 2 || k < 1)
            return 0;

        int len = prices.length;
        int[][] dailyRets = new int[k+1][len];

        for (int kk=1; kk<=k; kk++)
            for (int i=1, max = 0; i<len; i++) {
                max = i == 1 ? dailyRets[kk - 1][i - 1] - prices[i - 1] : Math.max(dailyRets[kk - 1][i - 1] - prices[i - 1], max);
                dailyRets[kk][i] = Math.max(max + prices[i], dailyRets[kk][i - 1]);
            }

        return dailyRets[k][len - 1];
    }

}
