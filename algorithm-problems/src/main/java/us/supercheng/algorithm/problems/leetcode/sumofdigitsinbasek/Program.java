package us.supercheng.algorithm.problems.leetcode.sumofdigitsinbasek;

public class Program {

    public int sumBase(int n, int k) {
        int ret = 0;

        for (; n != 0; n /= k)
            ret += n % k;

        return ret;
    }

}
