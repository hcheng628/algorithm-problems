package us.supercheng.algorithm.problems.leetcode.countoperationstoobtainzero;

class Solution {

    public int countOperations1Liner(int num1, int num2) {
        return num1 == 0 || num2 == 0 ? 0 : 1 + (num1 < num2 ? countOperations(num1, num2 - num1) : countOperations(num1 - num2, num2));
    }

    public int countOperations(int num1, int num2) {
        int ret = 0;

        while (num1 != 0 && num2 != 0)
            if (num1 < num2) {
                ret += num2 / num1;
                num2 = num2 % num1;
            } else {
                ret += num1 / num2;
                num1 = num1 % num2;
            }

        return ret;
    }

}
