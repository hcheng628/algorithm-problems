package us.supercheng.algorithm.problems.richestcustomerwealth;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int ret = 0;

        for (int[] banks : accounts) {
            int sum = 0;
            for (int b : banks)
                sum +=b;

            if (sum > ret)
                ret = sum;
        }

        return ret;
    }
}