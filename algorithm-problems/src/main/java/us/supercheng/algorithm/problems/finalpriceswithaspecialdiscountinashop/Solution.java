package us.supercheng.algorithm.problems.finalpriceswithaspecialdiscountinashop;

public class Solution {

    public int[] finalPrices(int[] prices) {
        for (int i=0, len = prices.length; i<len;i++)
            prices[i] = prices[i] - this.getD(prices, len, i);
        return prices;
    }

    public int getD(int[] p, int len, int curr) {
        for (int idx=curr+1; idx < len; idx++)
            if (p[idx] <= p[curr])
                return p[idx];

        return 0;
    }

}