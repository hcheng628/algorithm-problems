package us.supercheng.algorithm.problems.subtracttheproductandsumofdigitsofaninteger;

public class Solution {

    public int subtractProductAndSum(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        int sum = chars[0] - '0',
            mul = sum;

        for (int i=1,len=chars.length;i<len;i++) {
            sum += chars[i] - '0';
            if (mul != 0)
                mul *= chars[i] - '0';
        }

        return mul - sum;
    }
}