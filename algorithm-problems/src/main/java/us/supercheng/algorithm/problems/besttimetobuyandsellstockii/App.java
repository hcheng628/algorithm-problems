package us.supercheng.algorithm.problems.besttimetobuyandsellstockii;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int [] arr = {7,6,4,4,5,5,3,1};
        System.out.println(app.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int total = 0;
        int thisReturn = 0;
        for (int i=0;i<prices.length;i++) {
            buy = Math.min(buy, prices[i]);
            int temp = thisReturn;
            thisReturn = Math.max(thisReturn, prices[i] - buy);
            total += thisReturn;
            if(thisReturn > temp) {
                thisReturn =0;
                buy = prices[i];
            }
        }
        return total;
    }
}