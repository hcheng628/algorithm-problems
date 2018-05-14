package us.supercheng.algorithm.problems.besttimetobuyandsellstock;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int [] arr = {7,6,4,3,1};
        System.out.println(app.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <2) {
            return 0;
        }
        int sellHigh = 0;
        int returnVal = 0;
        int buyLow = prices[0];
        for (int i=1;i<prices.length;i++) {
            int temp = buyLow;
            buyLow = Math.min(buyLow, prices[i]);
            if (buyLow == temp) {
                sellHigh = Math.max(sellHigh, prices[i]);
            } else {
                sellHigh = 0;
            }
            returnVal = Math.max(returnVal, sellHigh - buyLow);
        }
        return returnVal;
    }

    public int maxProfitC(int[] prices) {
        int currMax = 0;
        for (int i=0; i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {
                currMax = Math.max(currMax,  prices[j] - prices[i]);
            }
        }
        return currMax;
    }
}