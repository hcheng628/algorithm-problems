package us.supercheng.algorithm.problems.leetcode.countintegerswithevendigitsum;

class Solution {

    public int countEven(int num) {
        int ret = 0;

        for (int n = num; n > 0; n--)
            if (this.digitsEven(n))
                ret++;

        return ret;
    }

    private boolean digitsEven(int n) {
        int sum = 0;

        for (; n != 0; n /= 10)
            sum += n % 10;

        return sum % 2 == 0;
    }

}
