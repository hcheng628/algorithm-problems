package us.supercheng.algorithm.problems.leetcode.calculatemoneyinleetcodebank;

public class Solution {

    public int totalMoney(int n) {
        int ret = 0;
        int base = 1 + 2 + 3 + 4 + 5 + 6 + 7;
        int amt = n / 7;
        int day = n % 7;

        for (int i=0; i<amt; i++) {
            ret += (i * 7) + base;
        }

        if (day != 0)
            amt++;

        for (int i=1; i<=day;i++)
            ret += amt++;

        return ret;
    }

}