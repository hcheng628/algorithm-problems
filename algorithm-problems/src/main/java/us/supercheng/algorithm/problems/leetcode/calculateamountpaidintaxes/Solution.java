package us.supercheng.algorithm.problems.leetcode.calculateamountpaidintaxes;

class Solution {

    public double calculateTax(int[][] brackets, int income) {
        if (brackets == null || brackets.length < 1)
            return 0.0;

        double ret = Math.min(income, brackets[0][0]) * (brackets[0][1] / 100.0);
        income -= Math.min(income, brackets[0][0]);

        for (int i = 1, taxable = 0; i < brackets.length; i++, income -= taxable) {
            taxable = Math.min(brackets[i][0] - brackets[i - 1][0], income);
            ret += taxable * (brackets[i][1] / 100.0);
        }

        return ret;
    }

}
